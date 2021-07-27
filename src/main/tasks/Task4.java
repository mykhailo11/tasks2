package main.tasks;

import java.math.BigInteger;

public class Task4 {

    private static final BigInteger LIMIT = BigInteger.valueOf(20000);

    private Task4() { }
    public static BigInteger getFibonacciNumber(BigInteger index) throws ArithmeticException, NullPointerException{
        if (index.compareTo(BigInteger.ZERO) < 0 || index.abs().compareTo(LIMIT) > 0){
            throw new ArithmeticException("The index is out of range");
        }
        BigInteger p = BigInteger.ZERO; // zero constant
        BigInteger c = BigInteger.ONE;  // one constant
        BigInteger n = p.add(c);        // function add() performs the same operation as operator +
        for (BigInteger i = BigInteger.ZERO;
             i.compareTo(index) < 0;    // function i.compareTo(index) returns -1 if i < index
             i = i.add(BigInteger.ONE)) {                                    // 0 if i == index
            p = c;                                                           // 1 if i > index
            c = n;
            n = p.add(c);
        }
        return p;
    }
    public static BigInteger getLimit(){
        return LIMIT;
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
