package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import main.tasks.Task1;
import main.tasks.Task2;
import main.tasks.Task3;
import main.tasks.Task4;
import main.tasks.Task5;
import java.math.BigInteger;

public class TasksTest {

    private final static BigInteger[][] task1Cases = new BigInteger[][]{
            {BigInteger.valueOf(40), BigInteger.valueOf(50)},
            {BigInteger.valueOf(-11), BigInteger.valueOf(45)},
            {BigInteger.valueOf(-321), BigInteger.valueOf(-43)},
            {BigInteger.valueOf(1012), BigInteger.valueOf(-5)}
    };
    private final static BigInteger[][] task2Cases2 = new BigInteger[][]{
            {BigInteger.valueOf(9), BigInteger.valueOf(4), BigInteger.valueOf(1), BigInteger.valueOf(1)},
            {BigInteger.valueOf(9), BigInteger.valueOf(4), BigInteger.valueOf(36), BigInteger.valueOf(9)},
            {BigInteger.valueOf(9), BigInteger.valueOf(4), BigInteger.valueOf(37), BigInteger.valueOf(1)},
            {BigInteger.valueOf(9), BigInteger.valueOf(4), BigInteger.valueOf(72), BigInteger.valueOf(9)}
    };
    private final static BigInteger[][] task2Cases1 = new BigInteger[][]{
            {BigInteger.valueOf(9), BigInteger.valueOf(4), BigInteger.valueOf(1), BigInteger.valueOf(1)},
            {BigInteger.valueOf(9), BigInteger.valueOf(4), BigInteger.valueOf(36), BigInteger.valueOf(1)},
            {BigInteger.valueOf(9), BigInteger.valueOf(4), BigInteger.valueOf(37), BigInteger.valueOf(2)},
            {BigInteger.valueOf(9), BigInteger.valueOf(4), BigInteger.valueOf(72), BigInteger.valueOf(2)}
    };
    private final static BigInteger[][] task3Cases = new BigInteger[][]{
            {BigInteger.valueOf(4), BigInteger.valueOf(16), BigInteger.valueOf(24), BigInteger.valueOf(36), BigInteger.valueOf(4)},
            {BigInteger.valueOf(9), BigInteger.valueOf(12), BigInteger.valueOf(18), BigInteger.valueOf(27), BigInteger.valueOf(3)},
            {BigInteger.valueOf(11), BigInteger.valueOf(4), BigInteger.valueOf(10), BigInteger.valueOf(9), BigInteger.valueOf(1)}
    };
    private final static BigInteger[][] task4Cases1 = new BigInteger[][]{
            {BigInteger.valueOf(1), BigInteger.valueOf(1)}, //0 1 1 2 3 5
            {BigInteger.valueOf(4), BigInteger.valueOf(3)},
            {BigInteger.valueOf(5), BigInteger.valueOf(5)},
            {BigInteger.valueOf(7), BigInteger.valueOf(13)},
            {BigInteger.valueOf(12), BigInteger.valueOf(144)},
            {BigInteger.valueOf(30), BigInteger.valueOf(832040)},
            {BigInteger.valueOf(37), BigInteger.valueOf(24157817)},
            {BigInteger.valueOf(40), BigInteger.valueOf(102334155)}
    };
    private final static BigInteger[] task4Cases2 = new BigInteger[]{
            BigInteger.valueOf(144),
            BigInteger.valueOf(0),
            BigInteger.valueOf(1),
            BigInteger.valueOf(102334155),
            BigInteger.valueOf(9227465)
    };
    private final static BigInteger[] task4Cases3 = new BigInteger[]{
            BigInteger.valueOf(143),
            BigInteger.valueOf(145),
            BigInteger.valueOf(4),
            BigInteger.valueOf(257568),
            BigInteger.valueOf(102334154),
            BigInteger.valueOf(102334156)
    };
    private final static BigInteger[][] task5Cases = new BigInteger[][]{
            {BigInteger.valueOf(2), BigInteger.valueOf(16), BigInteger.valueOf(6), BigInteger.valueOf(3)},
            {BigInteger.valueOf(4), BigInteger.valueOf(11), BigInteger.valueOf(0), BigInteger.valueOf(1)}
    };

    @Test
    public void afterChangeValueCalledBAndAAreReplaced() {
        for (BigInteger[] pair : task1Cases) {
            Task1 task1 = new Task1(pair[0], pair[1]);
            task1.changeValues();
            assertEquals(pair[1], task1.getA());
            assertEquals(pair[0], task1.getB());
        }
    }

    @Test
    public void getBlockReturnsBlockNumberOfSpecifiedRoomNumber() {
        for (BigInteger[] params : task2Cases1) {
            Task2 task2 = new Task2(params[0], params[1]);
            assertEquals(params[3], task2.getBlock(params[2]));
        }
    }

    @Test
    public void getStageReturnsStageNumberOfSpecifiedRoomNumber() {
        for (BigInteger[] params : task2Cases2) {
            Task2 task2 = new Task2(params[0], params[1]);
            assertEquals(params[3], task2.getStage(params[2]));
        }
    }

    @Test
    public void evaluateGCDReturnsTheGreatestCommonDividerOfFourNumbers() {
        for (BigInteger[] nums : task3Cases) {
            Task3 task3 = new Task3(nums[0], nums[1], nums[3], nums[2]);
            assertEquals(nums[4], task3.evaluateGCD());
        }
    }

    @Test
    public void getFibonacciNumberReturnsNumberInFibonacciSequenceAtSpecifiedIndex() {
        for (BigInteger[] pair : task4Cases1) {
            assertEquals(pair[1], Task4.getFibonacciNumber(pair[0]));
        }
    }

    @Test
    public void isFibonacciNumberReturnsTrueIfTheNumberIsFibonacciNumber() {
        for (BigInteger number : task4Cases2) {
            assertTrue(Task4.isFibonacci(number));
        }
    }

    @Test
    public void isFibonacciNumberReturnsFalseIfTheNumberIsNotFibonacciNumber() {
        for (BigInteger number : task4Cases3) {
            assertFalse(Task4.isFibonacci(number));
        }
    }

    @Test
    public void getIndexOfFibonacciNumberReturnsIndexOfTheSpecifiedFibonacciNumber() {
        for (BigInteger[] pair : task4Cases1) {
            assertEquals(pair[0].longValue(), Task4.getIndexOfFibonacciNumber(pair[1]));
        }
    }

    @Test
    public void getWeekDayOfReturnsDayOfTheWeekAccordingToTheSpecifiedDay() {
        for (BigInteger[] params : task5Cases) {
            assertEquals(params[3], Task5.getWeekDayOf(params[0], params[1], params[2]));
        }
    }
}
