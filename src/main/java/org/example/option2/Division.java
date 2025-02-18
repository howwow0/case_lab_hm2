package org.example.option2;

class Division extends Operation {
    public Division(double a, double b) {
        super(a, b);
    }

    @Override
    public double calculate() {
        if (b == 0) {
            return 0;
        }
        return a / b;
    }
}