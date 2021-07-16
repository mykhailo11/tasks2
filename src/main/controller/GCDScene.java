package main.controller;

import main.tasks.Task3;
import main.view.Renderer;
import main.view.Subscriber;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Queue;

public class GCDScene implements SceneState, Subscriber {

    private final Renderer renderer;
    private final StatedClass statedClass;

    public GCDScene(StatedClass statedClass){
        renderer = new Renderer();
        renderer.subscribe(this);
        this.statedClass = statedClass;
    }
    @Override
    public void render() {
        renderer.addInput("Enter 1 number: ");
        renderer.addInput("Enter 2 number: ");
        renderer.addInput("Enter 3 number: ");
        renderer.addInput("Enter 4 number: ");
        renderer.render();
    }
    private void renderResult(BigInteger gcd){
        renderer.addLabel("The GCD of these numbers is " + gcd);
        renderer.render();
    }
    @Override
    public void alert() {
        try{
            Queue<String> inputs = renderer.getInputs();
            BigInteger first = new BigInteger(Objects.requireNonNull(inputs.poll()));
            BigInteger second = new BigInteger(Objects.requireNonNull(inputs.poll()));
            BigInteger third = new BigInteger(Objects.requireNonNull(inputs.poll()));
            BigInteger fourth = new BigInteger(Objects.requireNonNull(inputs.poll()));
            Task3 task3 = new Task3(first, second, third, fourth);
            renderResult(task3.evaluateGCD());
            if (statedClass.isEndless()){
                statedClass.changeState(new MainScene(statedClass));
            }
        }catch (NumberFormatException | NullPointerException ex){
            statedClass.changeState(new ErrorScene(statedClass, ex.getMessage()));
        }
    }
}
