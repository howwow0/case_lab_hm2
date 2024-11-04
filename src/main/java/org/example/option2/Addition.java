package org.example.option2;

class Addition extends Operation {
    public Addition(double a, double b) {
        super(a, b);
    }

    @Override
    public double calculate() {
        return a + b;
    }
}