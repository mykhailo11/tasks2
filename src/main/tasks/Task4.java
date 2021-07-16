package main.tasks;

import java.math.BigInteger;

public class Task4 {
    
    private Task4() { }
    public static BigInteger getFibonacciNumber(BigInteger index){
        if (index.compareTo(BigInteger.ZERO) <= 0){
            return BigInteger.ZERO;
        }
        if (index.compareTo(BigInteger.ONE) == 0){
            return BigInteger.ONE;
        }
        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(index) <= 0; i = i.add(BigInteger.ONE)){
            BigInteger buf = previous;
            previous = current;
            current = buf.add(previous);
        }
        return current;
    }
}
