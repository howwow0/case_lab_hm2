package org.example.option2;

import javax.swing.*;
public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new MainCalculator().getPanel());
            frame.pack();
            frame.setVisible(true);
        });
    }

}
