package org.example.option2;

class Multiplication extends Operation {
    public Multiplication(double a, double b) {
        super(a, b);
    }

    @Override
    public double calculate() {
        return a * b;
    }
}