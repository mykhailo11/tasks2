package main.controller;

import main.tasks.Task5;
import main.view.Renderer;
import main.view.Subscriber;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Queue;

public class WeekDayScene implements SceneState, Subscriber {

    private final Renderer renderer;
    private final RenderedStatedClass statedClass;

    public WeekDayScene(RenderedStatedClass statedClass){
        renderer = new Renderer();
        renderer.subscribe(this);
        this.statedClass = statedClass;
    }
    @Override
    public void render() {
        renderer.addInput("Enter number of a week day on the New Year: ");
        renderer.addInput("Enter desired month day number: ");
        renderer.addInput("Enter desired month number: ");
        renderer.render();
    }
    private void renderResult(BigInteger day){
        renderer.addLabel("The weekday of the date is " + day);
        renderer.render();
    }

    @Override
    public void alert() {
        try{
            Queue<String> inputs = renderer.getInputs();
            BigInteger newYearWeekDay = new BigInteger(Objects.requireNonNull(inputs.poll())).subtract(BigInteger.ONE);
            BigInteger monthDay = new BigInteger(Objects.requireNonNull(inputs.poll())).subtract(BigInteger.ONE);
            BigInteger month = new BigInteger(Objects.requireNonNull(inputs.poll())).subtract(BigInteger.ONE);
            renderResult(Task5.getWeekDayOf(newYearWeekDay, monthDay, month).add(BigInteger.ONE));
            if (statedClass.isEndless()){
                statedClass.changeState(new MainScene(statedClass));
            }
        }catch (NumberFormatException | NullPointerException ex){
            statedClass.changeState(new ErrorScene(statedClass, ex.getMessage()));
        }
    }
}
