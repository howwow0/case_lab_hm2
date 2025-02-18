package org.example.option2;

import javax.swing.*;
public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Калькулятор");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new MainCalculator().getPanel());
            frame.pack();
            frame.setResizable(false);
            frame.setVisible(true);

        });
    }

}
