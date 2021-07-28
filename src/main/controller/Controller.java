package main.controller;

import main.view.Renderer;
import org.springframework.beans.factory.annotation.Autowired;

public class Controller implements RenderedStatedClass {

    private SceneState state;
    private final boolean endless;
    @Autowired
    private Renderer renderer;

    @Override
    public void changeState(SceneState state) {
        renderer.addLabel("Stage changed");
        renderer.render();
        this.state = state;
        this.state.render();
    }
    public Controller(boolean endless){
        this.endless = endless;
    }
    public SceneState getState(){
        return state;
    }
    @Override
    public boolean isEndless(){
        return endless;
    }
}
