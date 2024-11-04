package org.example.option2;

class Modulus extends Operation {
    public Modulus(double a, double b) {
        super(a, b);
    }

    @Override
    public double calculate() {
        if (b == 0) {
            throw new ArithmeticException("Остаток от деления на ноль невозможен");
        }
        return a % b;
    }
}