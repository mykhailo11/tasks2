package main.tasks;

import java.util.Arrays;
import java.math.BigInteger;

public class Task3 {

    private static final int SIZE = 4;
    private final BigInteger[] nums;

    public Task3(BigInteger... nums) throws IllegalArgumentException{
        if (nums.length < SIZE){
            throw new IllegalArgumentException("Too few arguments passed");
        }
        this.nums = Arrays.copyOf(nums, SIZE);
    }
    public void setNumbers(BigInteger... nums){
        if (nums.length < SIZE){
            throw new IllegalArgumentException("Too few arguments passed");
        }
        System.arraycopy(nums, 0, this.nums, 0, SIZE);
    }

    public BigInteger evaluateGCD(){
        return gcd(findMin());
    }
    private BigInteger findMin(){
        BigInteger min = nums[0];
        for (BigInteger num : nums){
            min = num.compareTo(min) < 0 ? num : min;
        }
        return min;
    }
    private BigInteger gcd(BigInteger min){
        BigInteger gcd = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(min) <= 0; i = i.add(BigInteger.ONE)){
            if (nums[0].mod(i).compareTo(BigInteger.ZERO) == 0 
            && nums[1].mod(i).compareTo(BigInteger.ZERO) == 0 
            && nums[2].mod(i).compareTo(BigInteger.ZERO) == 0 
            && nums[3].mod(i).compareTo(BigInteger.ZERO) == 0){
                gcd = i;
            }
        }
        return gcd;
    }
}
