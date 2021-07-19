package main.tasks;

import java.math.BigInteger;

public class Task4 {
    
    private Task4() { }
    public static BigInteger getFibonacciNumber(BigInteger index){
        if (index.compareTo(BigInteger.ZERO) < 0){
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
    public static boolean isFibonacci(BigInteger fibonacciNum){
        BigInteger base = fibonacciNum.pow(2).multiply(BigInteger.valueOf(5));
        return base.add(BigInteger.valueOf(4)).equals(base.add(BigInteger.valueOf(4)).sqrt().pow(2)) || base.subtract(BigInteger.valueOf(4)).equals(base.subtract(BigInteger.valueOf(4)).sqrt().pow(2));
    }
    public static long getIndexOfFibonacciNumber(BigInteger fibonacciNum){
        if (!isFibonacci(fibonacciNum)){
            return -1;
        }
        if (fibonacciNum.equals(BigInteger.ZERO) || fibonacciNum.equals(BigInteger.ONE)){
            return fibonacciNum.longValue();
        }
        return Math.round(2.078087 * Math.log(fibonacciNum.longValue()) + 1.672276);
    }
}
