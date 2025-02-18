package org.example.option2;

import javax.swing.*;

public class CalculatorUtils {
    public static void CheckAndAddNumberToField(JTextField field, char digit) {
        String text = field.getText();
        if (text.equals("0")) {
            field.setText(String.valueOf(digit));
        } else {
            field.setText(text + digit);
        }
    }

    public static double parseDouble(String text) {
        return Double.parseDouble(text.replace(',', '.'));
    }

    public static int getCountDigits(String text) {
        return text.length();
    }
}