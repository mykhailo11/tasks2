package main.controller;

import main.view.Renderer;
import main.view.Subscriber;

public class ErrorScene implements SceneState, Subscriber {

    private final Renderer renderer;
    private final RenderedStatedClass statedClass;
    private final String error;

    public ErrorScene(RenderedStatedClass statedClass, String error){
        renderer = new Renderer();
        renderer.subscribe(this);
        this.statedClass = statedClass;
        this.error = error;
    }
    @Override
    public void render() {
        renderer.addLabel("Something went wrong: " + error);
        renderer.render();
    }

    @Override
    public void alert() {
        if (statedClass.isEndless()){
            statedClass.changeState(new MainScene(statedClass));
        }
    }
}
