package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import ch.obermuhlner.math.big.BigDecimalMath;
import org.junit.jupiter.api.Test;
import main.tasks.Task1;
import main.tasks.Task2;
import main.tasks.Task3;
import main.tasks.Task4;
import main.tasks.Task5;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class TasksTest {

    private final static BigInteger[][] task4Cases1 = new BigInteger[][]{
            {BigInteger.valueOf(0), BigInteger.valueOf(0)},
            {BigInteger.valueOf(1), BigInteger.valueOf(1)},
            {BigInteger.valueOf(4), BigInteger.valueOf(3)},
            {BigInteger.valueOf(5), BigInteger.valueOf(5)},
            {BigInteger.valueOf(7), BigInteger.valueOf(13)},
            {BigInteger.valueOf(12), BigInteger.valueOf(144)},
            {BigInteger.valueOf(30), BigInteger.valueOf(832040)},
            {BigInteger.valueOf(37), BigInteger.valueOf(24157817)},
            {BigInteger.valueOf(40), BigInteger.valueOf(102334155)}
    };

    @ParameterizedTest
    @ArgumentsSource(changeValueArgumentsProvider.class)
    public void afterChangeValueCalledBAndAAreReplaced(BigInteger a, BigInteger b) {
            Task1 task1 = new Task1(a, b);
            task1.changeValues();
            assertEquals(b, task1.getA());
            assertEquals(a, task1.getB());
    }

    @ParameterizedTest
    @ArgumentsSource(getBlockArgumentsProvider.class)
    public void getBlockReturnsBlockNumberOfSpecifiedRoomNumber(BigInteger stages, BigInteger rooms,
                                                                BigInteger room, BigInteger block) {
            Task2 task2 = new Task2(stages, rooms);
            assertEquals(block, task2.getBlock(room));
    }

    @ParameterizedTest
    @ArgumentsSource(getStageArgumentsProvider.class)
    public void getStageReturnsStageNumberOfSpecifiedRoomNumber(BigInteger stages, BigInteger rooms,
                                                                BigInteger room, BigInteger stage) {
            Task2 task2 = new Task2(stages, rooms);
            assertEquals(stage, task2.getStage(room));
    }

    @ParameterizedTest
    @ArgumentsSource(evaluateGCDArgumentsProvider.class)
    public void evaluateGCDReturnsTheGreatestCommonDividerOfFourNumbers(BigInteger result, BigInteger one,
                                                                        BigInteger two, BigInteger three,
                                                                        BigInteger four) {
            Task3 task3 = new Task3(one, two, three, four);
            assertEquals(result, task3.evaluateGCD());
    }

    @Test
    public void getFibonacciNumberReturnsNumberInFibonacciSequenceAtSpecifiedIndex() {

        //check whether the method returns 0-th Fibonacci number
        assertEquals(BigInteger.ZERO, Task4.getFibonacciNumber(BigInteger.ZERO));
        System.out.println("The 0-th passed");

        //check whether the method returns 1-st Fibonacci number
        assertEquals(BigInteger.ONE, Task4.getFibonacciNumber(BigInteger.ONE));
        System.out.println("The 1-th passed");

        //starting from the 2-nd element till the limit
        for (BigInteger i = BigInteger.TWO, limit = Task4.getLimit().divide(BigInteger.valueOf(4));
             i.compareTo(limit) <= 0;
             i = i.add(BigInteger.ONE)){

            //getting potential i-th Fibonacci number
            BigInteger fibonacciNum = Task4.getFibonacciNumber(i);

            //it is known that if A is a Fibonacci number than either
            // (5 * (A ^ 2) + 4) or
            // (5 * (A ^ 2) - 4) is a perfect square
            BigInteger base = fibonacciNum.pow(2).multiply(BigInteger.valueOf(5)); //equals to ((A ^ 2) * 5)
            BigInteger expr1 = base.add(BigInteger.valueOf(4));                    //equals to ((A ^ 2) * 5 + 4)
            BigInteger expr2 = base.add(BigInteger.valueOf(-4));                   //equals to ((A ^ 2) * 5 - 4)
            boolean expr1IsPerfectSquare = expr1.equals(expr1.sqrt().pow(2));
            boolean expr2IsPerfectSquare = expr2.equals(expr2.sqrt().pow(2));

            //check whether it is true
            assertTrue(expr1IsPerfectSquare || expr2IsPerfectSquare);

            //it is known that if A is a Fibonacci number (starting from the 2-nd) then index is equals to
            // round(2.078087... * ln(A) + 1.672276...) for bigger value of A the approximation is more strict
            //where round(number) returns the nearest integer to the specified number
            BigInteger actual = BigDecimal.valueOf(2.078087).multiply(BigDecimalMath.log(new BigDecimal(fibonacciNum),
                            new MathContext(100, RoundingMode.HALF_UP))).add(BigDecimal.valueOf(1.672276))
                    .setScale(0, RoundingMode.HALF_UP).toBigInteger();

            //check whether the passed index is equal to the actual Fibonacci number index
            assertEquals(i, actual);
            //print message about the exact test case success
            System.out.println("The " + i + "-th passed");
        }
    }

    @ParameterizedTest
    @NullSource
    public void getFibonacciNumberThrowsNullPointerExceptionWhenNullPassed(BigInteger index){
        assertThrows(NullPointerException.class, () -> Task4.getFibonacciNumber(index));
    }

    @ParameterizedTest
    @ValueSource(longs = {-1, -10, -9876, -654})
    public void getFibonacciNumberThrowsArithmeticExceptionWhenNegativeIndexPassed(long index){
            assertThrows(ArithmeticException.class, () -> Task4.getFibonacciNumber(BigInteger.valueOf(index)));
    }
    @ParameterizedTest
    @ValueSource(longs = {1, 1000, 1878, 454})
    public void getFibonacciNumberTrowsArithmeticExceptionWhenTooBigNumberPassed(long addition){

        BigInteger limit = Task4.getLimit();
        assertThrows(ArithmeticException.class, () -> Task4.getFibonacciNumber(limit.add(BigInteger.valueOf(addition))));
        assertThrows(ArithmeticException.class, () -> Task4.getFibonacciNumber(limit.negate()
                .subtract(BigInteger.valueOf(addition))));
    }
    @ParameterizedTest
    @ValueSource(longs = {0, 1, 102334155, 9227465})
    public void isFibonacciNumberReturnsTrueIfTheNumberIsFibonacciNumber(long value) {
            assertTrue(Task4.isFibonacci(BigInteger.valueOf(value)));
    }

    @ParameterizedTest
    @ValueSource(longs = {143, 4, 257568, 102334154, 102334156})
    public void isFibonacciNumberReturnsFalseIfTheNumberIsNotFibonacciNumber(long value) {
            assertFalse(Task4.isFibonacci(BigInteger.valueOf(value)));
    }

    @Test
    public void getIndexOfFibonacciNumberReturnsIndexOfTheSpecifiedFibonacciNumber() {
        for (BigInteger[] pair : task4Cases1) {
            assertEquals(pair[0].longValue(), Task4.getIndexOfFibonacciNumber(pair[1]));
        }
    }

    @ParameterizedTest
    @ArgumentsSource(getWeekDayOfArgumentsProvider.class)
    public void getWeekDayOfReturnsDayOfTheWeekAccordingToTheSpecifiedDay(BigInteger newYearWeekDay,
                                                                          BigInteger monthDay,
                                                                          BigInteger month, BigInteger weekDay) {
        assertEquals(weekDay, Task5.getWeekDayOf(newYearWeekDay, monthDay, month));
    }
}
