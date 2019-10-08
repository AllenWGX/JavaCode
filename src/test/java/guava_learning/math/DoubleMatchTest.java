package guava_learning.math;

import org.junit.Test;

import com.google.common.math.DoubleMath;

public class DoubleMatchTest {
    @Test
    public void factorialTest(){
        double result = DoubleMath.factorial(10);   //n <= 170
        System.out.println(result);
        result =  DoubleMath.factorial(200);
        System.out.println(result);
    }
    
    @Test
    public void isPowerOfTwoTest(){
        boolean bool = DoubleMath.isPowerOfTwo(10.0);
        System.out.println(bool);
        bool = DoubleMath.isPowerOfTwo(4.0);
        System.out.println(bool);
    }
}
