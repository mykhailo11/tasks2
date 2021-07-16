package main;

import main.controller.Controller;
import main.controller.MainScene;

public class App {
    public static void main(String[] args){
        Controller controller = new Controller(true);
        controller.changeState(new MainScene(controller));
    }
}
