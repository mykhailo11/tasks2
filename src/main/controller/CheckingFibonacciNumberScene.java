package main.controller;

import main.tasks.Task4;
import main.view.Renderer;
import main.view.Subscriber;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Queue;

public class CheckingFibonacciNumberScene implements SceneState, Subscriber {

    private final Renderer renderer;
    private final RenderedStatedClass statedClass;

    public CheckingFibonacciNumberScene(RenderedStatedClass statedClass){
        renderer = new Renderer();
        renderer.subscribe(this);
        this.statedClass = statedClass;
    }
    @Override
    public void render() {
        renderer.addInput("Enter the Fibonacci number: ");
        renderer.render();
    }
    private void renderResult(boolean result){
        renderer.addLabel(result ? "The number is real Fibonacci number" : "The number is not a Fibonacci one");
        renderer.render();
    }

    @Override
    public void alert() {
        try{
            Queue<String> inputs = renderer.getInputs();
            BigInteger fiboNum = new BigInteger(Objects.requireNonNull(inputs.poll()));
            renderResult(Task4.isFibonacci(fiboNum));
            if (statedClass.isEndless()){
                statedClass.changeState(new MainScene(statedClass));
            }
        }catch (NumberFormatException | NullPointerException ex){
            statedClass.changeState(new ErrorScene(statedClass, ex.getMessage()));
        }
    }
}
