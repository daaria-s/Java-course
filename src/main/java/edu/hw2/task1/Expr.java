package edu.hw2.task1;

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
            return "(" + value.toString() + " ^ " + degree + ")";
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
