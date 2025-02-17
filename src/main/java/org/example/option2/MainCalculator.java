package org.example.option2;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCalculator {
    private JPanel panel1;
    private JTextField textField1;
    private JButton _Button;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a7Button;
    private JButton a0Button;
    private JButton a2Button;
    private JButton a5Button;
    private JButton a8Button;
    private JButton button1;
    private JButton a3Button1;
    private JButton a6Button;
    private JButton a9Button;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton sqrtButton;
    private JButton x2Button;
    private JButton a1XButton;
    private JButton delButton;
    private JButton cButton;
    private JButton CEButton;
    private JButton button13;
    private JLabel result;

    public JPanel getPanel() {
        return panel1;
    }

    Calculator calculator = new Calculator();

    public MainCalculator() {
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        cButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                result.setText("");
                textField1.setText("0");
                super.mouseClicked(e);
            }
        });
        CEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField1.setText("0");
                super.mouseClicked(e);
            }
        });
        delButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String res = textField1.getText();
                if(res.length() == 1)
                    textField1.setText("0");
                else
                    textField1.setText(res.substring(0, res.length() - 1));
            }
        });
     a1Button.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             SetNumber('1');
         }
     });
     a2Button.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             SetNumber('2');
         }
     });
     a3Button1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             SetNumber('3');
         }
     });
     a4Button.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             SetNumber('4');
         }
     });
     a5Button.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             SetNumber('5');
         }
     });
     a6Button.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             SetNumber('6');
         }
     });
     a7Button.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             SetNumber('7');
         }
     });
     a8Button.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             SetNumber('8');
         }
     });
     a9Button.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             SetNumber('9');
         }
     });
     a0Button.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            SetNumber('0');
         }
     });
     button1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             String res = textField1.getText();
             if(res.length() == 1)
                 return;


         }
     });
    }

    private void SetNumber(Character number) {
        String res = textField1.getText();

        if (res.startsWith("0") && Character.isDigit(number)) {
            res = "";
        }
        textField1.setText(res + number);
    }
}
