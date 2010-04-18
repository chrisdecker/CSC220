/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-00-00

Purpose
=======
To solve the Programming Exercise 17.17 (7e 16.7)

    Displaying a Calendar
    ---------------------
    Write a program that displays the calendar for the current month,
    as shown in figure (7e 16.48). Use labels, and set texts in the
    labels to display the calendar. Use the Gregorian Calendar class in
    section 11.3, "Example: ``Calendar`` and ``GregorianCalendar``" to
    obtain the information about the month, year, first day of the
    month, and number of days in the month.

*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;

import java.awt.Color;

import java.text.DateFormatSymbols;
import java.util.GregorianCalendar;

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
    CalendarWindow() {
        this.setLayout(new GridLayout(0,1,5,5));
        this.setSize(600,480);
        
        JPanel weekday_labels = new JPanel(new GridLayout(1,0,5,5));
        
        DateFormatSymbols symbols = new DateFormatSymbols();
        String[] weekday_symbols = symbols.getWeekdays();
        
        for(int i = 1; i < weekday_symbols.length; i++) {
            JLabel weekday = new JLabel(weekday_symbols[i]);
            weekday.setHorizontalAlignment(JLabel.CENTER);
            weekday.setVerticalAlignment(JLabel.BOTTOM);
            weekday_labels.add(weekday);
        }
        
        JPanel day_grid = new JPanel(new GridLayout(0,7,5,5));
        
        for (int i = 0; i < 31; i++) {
            JLabel day = new JLabel(""+i);
            day.setHorizontalAlignment(JLabel.CENTER);
            day_grid.add(day);
        }
        
        this.add(weekday_labels);
        this.add(day_grid);
    }
}
