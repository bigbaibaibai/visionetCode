package test;

import org.junit.Test;

import java.math.BigDecimal;

public class TestBigDecimal {

    @Test
    public void testBigDecimal() {
        BigDecimal decimal = new BigDecimal(21);
        BigDecimal decimal1 = new BigDecimal(20);
        System.out.println(decimal.divide(decimal1).intValue());

        // 1 public BigDecimal add(BigDecimal value);                        //加法
        // 2 public BigDecimal subtract(BigDecimal value);                   //减法
        // 3 public BigDecimal multiply(BigDecimal value);                   //乘法
        // 4 public BigDecimal divide(BigDecimal value);                     //除法
    }

}
