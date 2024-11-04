package org.example.option2;

class Power extends Operation {
    public Power(double a, double b) {
        super(a, b);
    }

    @Override
    public double calculate() {
        return Math.pow(a, b);
    }
}