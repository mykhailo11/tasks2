package main.controller;

import main.tasks.Task4;
import main.view.Renderer;
import main.view.Subscriber;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Queue;

public class FibonacciIndexScene implements Subscriber, SceneState {

    private final Renderer renderer;
    private final RenderedStatedClass statedClass;

    public FibonacciIndexScene(RenderedStatedClass statedClass){
        renderer = new Renderer();
        renderer.subscribe(this);
        this.statedClass = statedClass;
    }
    @Override
    public void render() {
        renderer.addInput("Enter Fibonacci number:");
        renderer.render();
    }
    public void renderResult(long result){
        renderer.addLabel(result >= 0 ? "The index of specified element is " + result : "The number is not a Fibonacci one");
        renderer.render();
    }

    @Override
    public void alert() {
        try {
            Queue<String> inputs = renderer.getInputs();
            renderResult(Task4.getIndexOfFibonacciNumber(new BigInteger(Objects.requireNonNull(inputs.poll()))));
            if (statedClass.isEndless()){
                statedClass.changeState(new MainScene(statedClass));
            }
        }catch (NumberFormatException | NullPointerException ex){
            statedClass.changeState(new ErrorScene(statedClass, ex.getMessage()));
        }
    }
}
