package edu.hw2;

import edu.hw2.task1.Expr;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    Random rn = new Random();

    void assertConstant(double value) {

        var constant = new Expr.Constant(value);
        assertEquals(value, constant.evaluate());
        assertEquals(Double.toString(value), constant.toString());
    }

    void assertNegate(Expr value) {
        var negateNumber = new Expr.Negate(value);
        assertEquals(value.evaluate() * (-1), negateNumber.evaluate());
        assertEquals("-" + value, negateNumber.toString());
    }

    @Test
    void constantTest() {
        for (int i = 0; i < 100; i++) {
            assertConstant(rn.nextDouble());
        }
    }

    @Test
    void negateTest() {
        for (int i = 0; i < 100; i++) {
            assertNegate(new Expr.Constant(rn.nextDouble()));
        }
    }

    @Nested
    class exponentTest {
        @Test
        void constantNumber() {
            for (int i = 0; i < 100; i++) {
                double generatedNumber = rn.nextDouble();
                Expr.Constant number = new Expr.Constant(generatedNumber);
                double degree = rn.nextDouble();
                Expr.Exponent exponent = new Expr.Exponent(number, degree);
                assertEquals(Math.pow(generatedNumber, degree), exponent.evaluate());
                assertEquals("(" + generatedNumber + " ^ " + degree + ")", exponent.toString());
            }
        }

        @Test
        void negateNumber() {
            for (int i = 0; i < 100; i++) {
                double generatedNumber = rn.nextDouble();
                Expr.Negate number = new Expr.Negate(new Expr.Constant(generatedNumber));
                double degree = rn.nextDouble();
                Expr.Exponent exponent = new Expr.Exponent(number, degree);
                assertEquals(Math.pow(generatedNumber * -1, degree), exponent.evaluate());
                assertEquals("(-" + generatedNumber + " ^ " + degree + ")", exponent.toString());
            }
        }

    }

    @Test
    void additionTest() {
        for (int i = 0; i < 100; i++) {
            double leftGeneratedNumber = rn.nextDouble();
            double rightGeneratedNumber = rn.nextDouble();

            Expr.Constant left = new Expr.Constant(leftGeneratedNumber);
            Expr.Constant right = new Expr.Constant(rightGeneratedNumber);

            Expr.Addition addition = new Expr.Addition(left, right);

            assertEquals(leftGeneratedNumber + rightGeneratedNumber, addition.evaluate());
            assertEquals("(" + leftGeneratedNumber + " + " + rightGeneratedNumber + ")", addition.toString());

        }
    }

    @Test
    void calculatingExpressionsCheck() {
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
