package main.controller;

import main.view.Renderer;
import main.view.Subscriber;
import java.util.Objects;
import java.util.Queue;

public class MainScene implements SceneState, Subscriber {

    private final Renderer renderer;
    private final RenderedStatedClass statedClass;

    public MainScene(RenderedStatedClass statedClass){
        renderer = new Renderer();
        renderer.subscribe(this);
        this.statedClass = statedClass;
    }
    @Override
    public void render() {
        renderer.addLabel("Choose option");
        renderer.addInput("Choose option:\n1 - Change numbers values\n2 - Get block and stage of the room\n3 - Get GCD of 4 numbers\n4 - Get Fibonacci number by index\n5 - Get day of the week corresponding to the date\n6 - Check Fibonacci number\n7 - Get index of a Fibonacci number\n8 - Exit");
        renderer.render();
    }

    @Override
    public void alert() {
        try{
            Queue<String> input = renderer.getInputs();
            int option = Integer.parseInt(Objects.requireNonNull(input.poll()));
            switch (option){
                case 1:
                    statedClass.changeState(new ChangeNumbersScene(statedClass));
                    break;
                case 2:
                    statedClass.changeState(new BlockStageScene(statedClass));
                    break;
                case 3:
                    statedClass.changeState(new GCDScene(statedClass));
                    break;
                case 4:
                    statedClass.changeState(new FibonacciScene(statedClass));
                    break;
                case 5:
                    statedClass.changeState(new WeekDayScene(statedClass));
                    break;
                case 6:
                    statedClass.changeState(new CheckingFibonacciNumberScene(statedClass));
                    break;
                case 7:
                    statedClass.changeState(new FibonacciIndexScene(statedClass));
                case 8:
                    break;
                default:
                    statedClass.changeState(new MainScene(statedClass));
            }
        }catch (NumberFormatException | NullPointerException ex){
            statedClass.changeState(new ErrorScene(statedClass, ex.getMessage()));
        }
    }
}
