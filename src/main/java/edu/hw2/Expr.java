package edu.hw2;


public sealed interface Expr {

    double evaluate();

    public record Constant(double value) implements Expr {

        @Override
        public double evaluate() {
            return value;
        }

        @Override
        public String toString() {
            return Double.toString(value);
        }
    }
    public record Negate(Expr value) implements Expr {

        @Override
        public double evaluate() {
            return -value.evaluate();
        }

        public String toString() {
            return "-" + value.toString();
        }
    }
    public record Exponent(Expr value, double degree) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(value.evaluate(), degree);
        }

        public String toString() {
            return  "(" + value.toString() + " ^ " + degree + ")";
        }
    }
    public record Addition(Expr left, Expr right) implements Expr {
        @Override
        public double evaluate() {
            return left.evaluate() + right.evaluate();
        }

        public String toString() {
            return "(" + left.toString() + " + " + right.toString() + ")";
        }
    }
    public record Multiplication(Expr left, Expr right) implements Expr {
        @Override
        public double evaluate() {
            return left.evaluate() * right.evaluate();
        }

        public String toString() {
            return "(" + left.toString() + " * " + right.toString() + ")";
        }
    }


}


class Main {

    public static void main(String[] args) {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult, 2);
        var res = new Expr.Addition(exp, new Expr.Constant(1));

        System.out.println(res + " = " + res.evaluate());
    }
}
