package org.example.option2;

class Calculator {
    public double calculate(double a, String operator, double b) {
        Operation operation;
        switch (operator) {
            case "+":
                operation = new Addition(a, b);
                break;
            case "-":
                operation = new Subtraction(a, b);
                break;
            case "*":
                operation = new Multiplication(a, b);
                break;
            case "/":
                operation = new Division(a, b);
                break;
            case "//":
                operation = new IntDivision(a, b);
                break;
            case "^":
                operation = new Power(a, b);
                break;
            case "%":
                operation = new Modulus(a, b);
                break;
            default:
                throw new IllegalArgumentException("Некорректный оператор");
        }
        return operation.calculate();
    }
}