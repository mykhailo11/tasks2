package main.controller;

import main.tasks.Task1;
import main.view.Renderer;
import main.view.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Queue;

@Component
public class ChangeNumbersScene implements SceneState, Subscriber {

    @Autowired
    private Renderer renderer;
    private final RenderedStatedClass statedClass;

    public ChangeNumbersScene(RenderedStatedClass statedClass){
        //renderer = new Renderer();
        this.statedClass = statedClass;
    }
    @Override
    public void render() {
        renderer.addInput("Enter a: ");
        renderer.addInput("Enter b: ");
        renderer.subscribe(this);
        renderer.render();
    }
    private void renderResult(BigInteger a, BigInteger b){
        renderer.addLabel("Now, a is " + a + " and b is " + b);
        renderer.render();
    }

    @Override
    public void alert() {
        try{
            Queue<String> inputs = renderer.getInputs();
            BigInteger a = new BigInteger(Objects.requireNonNull(inputs.poll()));
            BigInteger b = new BigInteger(Objects.requireNonNull(inputs.poll()));
            Task1 task1 = new Task1(a, b);
            task1.changeValues();
            renderResult(a, b);
            if (statedClass.isEndless()){
                statedClass.changeState(new MainScene(statedClass));
            }
        }catch (NumberFormatException | NullPointerException ex){
            statedClass.changeState(new ErrorScene(statedClass, ex.getMessage()));
        }
    }
}
