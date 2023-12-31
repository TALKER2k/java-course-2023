package edu.hw2;


public final class Task1 {
    private Task1() {}

    public sealed interface Expr {
        double evaluate();

        record Constant(double number) implements Expr {
            @Override
            public double evaluate() {
                return this.number;
            }
        }

        record Negate(Expr number) implements Expr {
            @Override
            public double evaluate() {
                return this.number.evaluate() * (-1);
            }
        }

        record Exponent(Expr number, int exponent) implements Expr {
            @Override
            public double evaluate() {
                return Math.pow(this.number.evaluate(), this.exponent);
            }
        }

        record Addition(Expr number1, Expr number2) implements Expr {
            @Override
            public double evaluate() {
                return this.number1.evaluate() + this.number2.evaluate();
            }
        }

        record Multiplication(Expr number1, Expr number2) implements Expr {
            @Override
            public double evaluate() {
                return this.number1.evaluate() * this.number2.evaluate();
            }
        }
    }
}
