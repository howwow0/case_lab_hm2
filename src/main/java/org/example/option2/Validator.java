package org.example.option2;

class Validator {
    public static boolean isValidExpression(String[] operators) {
        return operators.length == 3 && "+-*/%^//".contains(operators[1]);
    }
}