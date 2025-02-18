package org.example.option2;

class IntDivision extends Operation {
    public IntDivision(double a, double b) {
        super(a, b);
    }

    @Override
    public double calculate() {
        if (b == 0) {
            return 0;
        }
        return (int) a / (int) b;
    }
}