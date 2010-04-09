/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-00-00

Purpose
=======
To solve the Programming Exercise 17.17 (7e 16.7)

    Displaying a Calendar
    ---------------------
    Write a program that displays the calendar for the current month,
    as shown in figure (7e 16.48). Use labels, and set texts ib the
    labels to display the calendar. Use the Gregorian Calendar class in
    section 11.3, "Example: ``Calendar`` and ``GregorianCalendar``" to
    obtain the information about the month, year, first day of the
    month, and number of days in the month.

*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;

/**
 * Driver class
 */
public class main {
    public static void main (String[] args) {
        CalendarWindow window = new CalendarWindow();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}

class CalendarWindow extends JFrame {
    JLabel date = new JLabel();
    JLabel day_names[] = new JLabel[7];
    JLabel days[] = new JLabel[31];
    
    CalendarWindow() {
        this.setLayout(new GridLayout(0,1,5,5));
        this.setSize(400,300);
        
        JPanel day_labels = new JPanel(new GridLayout(1,0,5,5));
        
        for(int i = 0; i < this.day_names.length; i++) {
            this.day_names[i] = new JLabel();
            day_labels.add(this.day_names[i]);
        }
        
        JPanel day_grid = new JPanel(new GridLayout(0,7,5,5));
        
        for (int i = 0; i < this.days.length; i++) {
            this.days[i] = new JLabel();
            day_grid.add(this.days[i]);
        }
        
        
    }
}
