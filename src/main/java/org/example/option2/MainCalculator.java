package org.example.option2;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCalculator {
    private JPanel panel1;
    private JTextField textField1;
    private JButton _Button;
    private JButton a1Button, a2Button, a3Button1, a4Button, a5Button, a6Button, a7Button, a8Button, a9Button, a0Button;
    private JButton button1, button2, button3, button4, button5, button6, sqrtButton, x2Button, a1XButton, delButton, cButton, CEButton, button13;
    private JButton msButton, mrButton, mPlusButton, mMinusButton, mcButton;
    private JLabel result;

    private double memory = 0.0;

    public JPanel getPanel() {
        return panel1;
    }

    Calculator calculator = new Calculator();
    boolean isNewInput = false;

    public MainCalculator() {

        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String expression = result.getText();
                String current = textField1.getText();
                if (!expression.isEmpty()) {
                    double a = CalculatorUtils.parseDouble(expression.split(" ")[0]);
                    String op = expression.split(" ")[1];
                    double b = CalculatorUtils.parseDouble(current);
                    double res = calculator.calculate(a, op, b);
                    textField1.setText(String.valueOf(res));
                    result.setText("");
                    isNewInput = true;
                }
            }
        });

        cButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                result.setText("");
                textField1.setText("0");
            }
        });

        CEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField1.setText("0");
            }
        });

        delButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String res = textField1.getText();
                if (res.length() > 1) {
                    textField1.setText(res.substring(0, res.length() - 1));
                } else {
                    textField1.setText("0");
                }
            }
        });

        MouseAdapter numberClickListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                String digit = button.getText();
                if (isNewInput) {
                    textField1.setText(digit);
                    isNewInput = false;
                } else {
                    CalculatorUtils.CheckAndAddNumberToField(textField1, digit.charAt(0));
                }
            }
        };

        a1Button.addMouseListener(numberClickListener);
        a2Button.addMouseListener(numberClickListener);
        a3Button1.addMouseListener(numberClickListener);
        a4Button.addMouseListener(numberClickListener);
        a5Button.addMouseListener(numberClickListener);
        a6Button.addMouseListener(numberClickListener);
        a7Button.addMouseListener(numberClickListener);
        a8Button.addMouseListener(numberClickListener);
        a9Button.addMouseListener(numberClickListener);
        a0Button.addMouseListener(numberClickListener);

        _Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String res = textField1.getText();
                if (!res.equals("0")) {
                    if (res.startsWith("-")) {
                        textField1.setText(res.substring(1));
                    } else {
                        textField1.setText("-" + res);
                    }
                }
            }
        });

        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String res = textField1.getText();
                if (!res.contains(".")) {
                    textField1.setText(res + ".");
                }
            }
        });

        button3.addMouseListener(new OperatorClickListener("+"));
        button4.addMouseListener(new OperatorClickListener("-"));
        button5.addMouseListener(new OperatorClickListener("*"));
        button6.addMouseListener(new OperatorClickListener("/"));

        sqrtButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double val = CalculatorUtils.parseDouble(textField1.getText());
                if (val < 0) {
                    textField1.setText("Ошибка");
                } else {
                    textField1.setText(String.valueOf(Math.sqrt(val)));
                }
            }
        });

        x2Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double val = CalculatorUtils.parseDouble(textField1.getText());
                textField1.setText(String.valueOf(new Power(val, 2).calculate()));
            }
        });

        a1XButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double val = CalculatorUtils.parseDouble(textField1.getText());
                if (val == 0) {
                    textField1.setText("Ошибка");
                } else {
                    textField1.setText(String.valueOf(new IntDivision(1, val).calculate()));
                }
            }
        });

        button13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double val = CalculatorUtils.parseDouble(textField1.getText());
                textField1.setText(String.valueOf(new Multiplication(val, 0.01).calculate()));
            }
        });

        msButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                memory = CalculatorUtils.parseDouble(textField1.getText());
            }
        });

        mrButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField1.setText(String.valueOf(memory));
            }
        });

        mPlusButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                memory += CalculatorUtils.parseDouble(textField1.getText());
            }
        });

        mMinusButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                memory -= CalculatorUtils.parseDouble(textField1.getText());
            }
        });

        mcButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                memory = 0.0;
            }
        });
    }

    class OperatorClickListener extends MouseAdapter {
        private final String operator;

        OperatorClickListener(String operator) {
            this.operator = operator;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            String res = textField1.getText();
            if (!result.getText().isBlank()) {
                double a = CalculatorUtils.parseDouble(result.getText().split(" ")[0]);
                String op = result.getText().split(" ")[1];
                double b = CalculatorUtils.parseDouble(res);
                double calculation = switch (op) {
                    case "+" -> new Addition(a, b).calculate();
                    case "-" -> new Subtraction(a, b).calculate();
                    case "*" -> new Multiplication(a, b).calculate();
                    case "/" -> new IntDivision(a, b).calculate();
                    default -> 0;
                };
                result.setText(calculation + " " + operator + " ");
                textField1.setText(String.valueOf(calculation));
            } else {
                result.setText(res + " " + operator + " ");
            }
            isNewInput = true;
        }
    }
}
