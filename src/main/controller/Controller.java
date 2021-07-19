package main.controller;

public class Controller implements RenderedStatedClass {

    private SceneState state;
    private final boolean endless;

    @Override
    public void changeState(SceneState state) {
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
