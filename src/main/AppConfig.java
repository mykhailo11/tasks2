package main;

import main.controller.Controller;
import main.tasks.Task1;
import main.tasks.Task2;
import main.tasks.Task3;
import main.view.Renderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.math.BigInteger;

@Configuration
@ComponentScan("main")
public class AppConfig {
    @Bean
    public Controller controller(){
        return new Controller(true);
    }
    @Bean
    @Scope("prototype")
    public Task1 task1(){
        return new Task1(BigInteger.ZERO, BigInteger.ZERO);
    }
    @Bean
    @Scope("prototype")
    public Task2 task2(){
        return new Task2(BigInteger.ONE, BigInteger.ONE);
    }
    @Bean
    @Scope("prototype")
    public Task3 task3(){
        return new Task3(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO);
    }
    @Bean
    @Scope("prototype")
    public Renderer renderer(){
        return new Renderer();
    }
}
