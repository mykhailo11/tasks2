package main.controller;

import main.tasks.Task4;
import main.view.Renderer;
import main.view.Subscriber;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Queue;

public class FibonacciScene implements SceneState, Subscriber {

    private final Renderer renderer;
    private final StatedClass statedClass;

    public FibonacciScene(StatedClass statedClass){
        renderer = new Renderer();
        renderer.subscribe(this);
        this.statedClass = statedClass;
    }
    @Override
    public void render() {
        renderer.addInput("Enter index: ");
        renderer.render();
    }
    private void renderResult(BigInteger index){
        renderer.addLabel("The Fibonacci number at " + index + " is " + Task4.getFibonacciNumber(index));
        renderer.render();
    }

    @Override
    public void alert() {
        try{
            Queue<String> input = renderer.getInputs();
            BigInteger index = new BigInteger(Objects.requireNonNull(input.poll()));
            renderResult(index);
            if (statedClass.isEndless()){
                statedClass.changeState(new MainScene(statedClass));
            }
        }catch (NumberFormatException | NullPointerException ex){
            statedClass.changeState(new ErrorScene(statedClass, ex.getMessage()));
        }
    }
}
