package org.example.option2;

class Subtraction extends Operation {
    public Subtraction(double a, double b) {
        super(a, b);
    }

    @Override
    public double calculate() {
        return a - b;
    }
}