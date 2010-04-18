/*
Author: Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-00-00

Purpose
=======
To solve the Programming Exercise 17.5 (7e 16.21)

    Creating a histogram for occurrences of letters
    -----------------------------------------------
    In Listing (7e 16.12), MultipleWindowsDemo.java,you developed a
    program that displays a histogram to show occurrences of each
    letter in a text area. Reuse the ``Histogram`` class created in
    Listing (7e 16.13) to write a program that will display a histogram
    on a panel. The histogram should show occurrences of each letter in
    a text file, as shown in Figure (7e 16.51). Assume that the letters
    are not case sensitive.

*/

import java.io.File;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * Driver class
 */
public class main {
    public static void main (String[] args)
        throws java.io.FileNotFoundException
    {
        Window window;
        
        if(args.length > 0) {
            File f = new File(args[0]);
            window = new Window(f);
            window.setVisible(true);
        } else {
            System.out.print("You must provide one plain-text file as "+
                "the first parameter to create a histogram from.\n");
        }
        
    }
}

class Window extends JFrame {
    public Window(File f)
        throws java.io.FileNotFoundException
    {
        this.setTitle(String.format("Histogram of %s",f));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Histogram histogram = new Histogram();
        histogram.showHistogram(this.countLetters(f));
        this.add(histogram);
        
        this.setSize(histogram.getPreferredSize());
    }
    
    private int[] countLetters(File f)
        throws java.io.FileNotFoundException
    {
        int[] count = new int[26];
        
        Scanner s = new Scanner(f);
        while(s.hasNext()) {
            String match = s.findWithinHorizon("([A-Za-z])",0);
            
            if(match != null) {
                match = match.toLowerCase();
                count[match.charAt(0) - 'a']++;
            } else {
                break;
            }
        }
        
        return count;
    }
}
