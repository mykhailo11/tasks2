package main.view;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

//@Component
public class Renderer implements Publisher {

    private final Queue<String> labels;
    private final Queue<String> inputsLabels;
    private final Queue<String> inputs;
    private final Queue<Subscriber> subs;

    public Renderer(){
        labels = new LinkedList<>();
        inputsLabels = new LinkedList<>();
        inputs = new LinkedList<>();
        subs = new LinkedList<>();
    }
    public void render(){
        while (!labels.isEmpty()){
            System.out.println(labels.poll());
        }
        inputs.clear();
        while (!inputsLabels.isEmpty()){
            inputs.add(Renderer.readLine(inputsLabels.poll()));
        }
        while (!subs.isEmpty()){
            subs.poll().alert();
        }
    }
    public Queue<String> getInputs(){
        return inputs;
    }
    public void addLabel(String label){
        labels.add(label);
    }
    public void addLabels(String... labels){
        this.labels.addAll(Arrays.asList(labels));
    }
    public void addInput(String inputLabel){
        inputsLabels.add(inputLabel);
    }
    public void addInputs(String... inputs){
        this.inputs.addAll(Arrays.asList(inputs));
    }
    @Override
    public void subscribe(Subscriber sub){
        subs.add(sub);
    }
    private static String readLine(String out){
        String result;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(out);
        try{
            result = reader.readLine();
        }catch (IOException ex){
            return "";
        }
        return result;
    }
}
