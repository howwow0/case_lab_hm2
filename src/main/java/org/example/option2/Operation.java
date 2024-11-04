package org.example.option2;

abstract class Operation {
    protected double a;
    protected double b;

    public Operation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public abstract double calculate();
}