package main.tasks;

import java.math.BigInteger;

public class Task1{

    private BigInteger a;
    private BigInteger b;

    public Task1(BigInteger a, BigInteger b){
        this.a = a;
        this.b = b;
    }
    public void setA(BigInteger a){
        this.a = a;
    }
    public void setB(BigInteger b){
        this.b = b;
    }
    public BigInteger getA(){
        return a;
    }
    public BigInteger getB(){
        return b;
    }
    public void changeValues(){
        a = a.add(b);
        b = a.subtract(b);
        a = a.subtract(b);
    }
}