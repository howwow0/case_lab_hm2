package org.example.option2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Поддерживаемые операции:");
        System.out.println("Сложение (+), Вычитание (-), Умножение (*), Деление (/)");
        System.out.println("Целочисленное деление (//), Возведение в степень (^), Остаток от деления (%)");
        System.out.println("Введите \"exit\" для завершения работы программы.");

        while (true) {
            System.out.print("Введите выражение (например, 5 + 3) или \"exit\" для выхода: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы.");
                break;
            }

            String[] operators = input.split(" ");
            if (!Validator.isValidExpression(operators)) {
                System.out.println("Неверный ввод. Попробуйте снова.");
                continue;
            }

            try {
                double a = Double.parseDouble(operators[0]);
                String operator = operators[1];
                double b = Double.parseDouble(operators[2]);
                double result = calculator.calculate(a, operator, b);
                System.out.println("Результат: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введены некорректные числа. Попробуйте снова.");
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

}
