package org.example.option2;

class IntDivision extends Operation {
    public IntDivision(double a, double b) {
        super(a, b);
    }

    @Override
    public double calculate() {
        if (b == 0) {
            throw new ArithmeticException("Целочисленное деление на ноль невозможно");
        }
        return (int) a / (int) b;
    }
}