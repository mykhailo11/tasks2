package main;

import main.controller.Controller;
import main.controller.MainScene;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        Controller controller = context.getBean(Controller.class);
        controller.changeState(new MainScene(controller));
    }
}
