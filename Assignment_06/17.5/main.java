/*
Author: Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-00-00

Purpose
=======
To solve the Programming Exercise 17.5 (7e 16.5)

    Create a mile/kilometer coverter
    --------------------------------
    Write a program that converts miles and kilometers as shown in
    Figure (7e 16.73). If you enter a value in the Mile text field and
    press the ``Enter`` key, the corresponding kilometer is displayed
    in the Kilometer text field, Likewise, if you enter a value in the
    Kilometer text field and press the ``Enter`` key, the corresponding
    mile is displayed in the Mile text field.

*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;

/**
 * Driver class
 */
public class main {
    public static void main (String[] args) {
        ConvertMileKilometer window = new ConvertMileKilometer();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
    }
}

class ConvertMileKilometer extends JFrame {
    JTextField txt_miles = new JTextField();
    JTextField txt_kilos = new JTextField();
    
    ConvertMileKilometer() {
        this.setLayout(new BorderLayout(5,5));
        this.setSize(300,75);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,2,5,5));
        this.add(panel);
        
        panel.add(new JLabel("Miles"));
        this.txt_miles.setColumns(15);
        panel.add(this.txt_miles);
        
        panel.add(new JLabel("Kilometers"));
        this.txt_kilos.setColumns(15);
        panel.add(this.txt_kilos);
    }
}
