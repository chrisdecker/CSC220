/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-00-00

16.4 - Simple Calculator
========================
Write a program with three text fields (two input one display), and
four buttons for addition, subtraction, multiplication and division.

*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Driver class
 */
class SimpleCalculator extends JFrame{
    private NumberField a = new NumberField();
    private NumberField b = new NumberField();
    private NumberField c = new NumberField();
    
    public SimpleCalculator() {
        this.setTitle("Simple Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5,5));
        this.setSize(300,80);
        
        this.a.setColumns(6);
        this.b.setColumns(6);
        this.c.setColumns(6);
        
        this.add(new JPanel() {{
            setLayout(new FlowLayout(5,5, FlowLayout.CENTER));
            
            c.setEditable(false);
            
            add(new JLabel("A"));
            add(a);
            add(new JLabel("B"));
            add(b);
            add(new JLabel("Result"));
            add(c);
        }}, BorderLayout.NORTH);
        
        this.add(new JPanel() {{
            setLayout(new GridLayout(1,4));
            
            add(new JButton("+") {{
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        c.setText(String.format("%f",
                            a.getDouble() + b.getDouble()));
                    }
                });
            }});
            
            add(new JButton("-") {{
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        c.setText(String.format("%f",
                            a.getDouble() - b.getDouble()));
                    }
                });
            }});
            
            add(new JButton("*") {{
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        c.setText(String.format("%f",
                            a.getDouble() * b.getDouble()));
                    }
                });
            }});
            
            add(new JButton("/") {{
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        c.setText(String.format("%f",a.getDouble() / b.getDouble()));
                    }
                });
            }});
        }}, BorderLayout.CENTER);
    }
    
    public static void main (String[] args) {
        SimpleCalculator calc = new SimpleCalculator();
        calc.setVisible(true);
    }
}

class NumberField extends JTextField {
    public double getDouble() {
        return Double.valueOf(this.getText());
    }
}
