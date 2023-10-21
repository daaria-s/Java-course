package edu.project1;

import edu.hw2.Expr;
import org.junit.jupiter.api.Test;

import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class Task1Test {


    Random rn = new Random();

    void assertConstant(double value) {

        var seven = new Expr.Constant(value);
        assertEquals(value, seven.evaluate());
        assertEquals(Double.toString(value), seven.toString());
    }

    @Test
    void constantTest() {
        for (int i = 0; i < 100; i++) {
            assertConstant(rn.nextDouble());
        }
    }


    @Test
    void test1() {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult, 2);
        var res = new Expr.Addition(exp, new Expr.Constant(1));
        assertEquals(37, res.evaluate());
        assertEquals("((((2.0 + 4.0) * -1.0) ^ 2.0) + 1.0)", res.toString());
    }
}
