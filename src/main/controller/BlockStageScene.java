package main.controller;

import main.tasks.Task2;
import main.view.Renderer;
import main.view.Subscriber;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Queue;

public class BlockStageScene implements SceneState, Subscriber {

    private final Renderer renderer;
    private final RenderedStatedClass statedClass;

    public BlockStageScene(RenderedStatedClass statedClass){
        renderer = new Renderer();
        renderer.subscribe(this);
        this.statedClass = statedClass;
    }
    @Override
    public void render() {
        renderer.addInput("Enter number of stages: ");
        renderer.addInput("Enter number of rooms on a stage: ");
        renderer.addInput("Enter desired room number: ");
        renderer.render();
    }
    private void renderResult(BigInteger stage, BigInteger block, BigInteger room){
        renderer.addLabel("The stage and block numbers of the " + room + " room are " + stage + " and " + block);
        renderer.render();
    }

    @Override
    public void alert() {
        try{
            Queue<String> inputs = renderer.getInputs();
            BigInteger stages = new BigInteger(Objects.requireNonNull(inputs.poll()));
            BigInteger rooms = new BigInteger(Objects.requireNonNull(inputs.poll()));
            BigInteger room = new BigInteger(Objects.requireNonNull(inputs.poll()));
            Task2 task2 = new Task2(stages, rooms);
            renderResult(task2.getStage(room), task2.getBlock(room), room);
            if (statedClass.isEndless()){
                statedClass.changeState(new MainScene(statedClass));
            }
        }catch (NumberFormatException | NullPointerException ex){
            statedClass.changeState(new ErrorScene(statedClass, ex.getMessage()));
        }
    }
}
