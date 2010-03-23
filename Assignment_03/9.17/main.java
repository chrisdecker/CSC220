/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-00-00

Purpose
=======
To solve Programming Exercise 9.17 (7e 8.17)

    Counting characters, words, and lines in a file
    -----------------------------------------------
    Write  a program that will count the number of characters
    (excluding control characters '\r' and '\n',) words, and lines in a
    file. Words are separated by spaces, tabs, carriage return, or
    line-feed characters. The file name should be passed as a
    command-line argument, as shown in figure 9.? (7e 8.21)::
        
        C:\exercise> java Exercise9_17 Loan.java
        File Loan.java has
        1715 characters
        211 words
        68 lines
        
        C:\exercises>

Document History
================
============= =========================================================
Date Modified Reason
============= =========================================================
2010-00-00    Document Created
============= =========================================================

*/

import java.io.File;
import java.util.Scanner;

/**
 * Driver class
 */
class main {
    public static void main (String[] args)
        throws java.io.FileNotFoundException
    {
        for(int i = 0; i < args.length; i++) {
            File f = new File(args[i]);
            
            if (f.canRead()) {
                System.out.printf(
                    "File %s has\n"+
                    "%d characters\n"+
                    "%d words\n"+
                    "%d lines\n",
                    args[i], main.characters(f),
                    main.words(f), main.lines(f));
            }
        }
    }
    
    /**
     * Count number of characters in file
     * 
     */
    static int characters(File f)
        throws java.io.FileNotFoundException
    {
        Scanner s = new Scanner(f);
        int characters = 0;
        
        while (s.hasNext()) {
            // THERE IS NO Scanner.nextChar()! WTH?!
            // http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=5066699
            // This issue is 6 YEARS OLD!
            s.findWithinHorizon("[^\r\n]", 0);
            characters = characters + 1;
        }
        
        s.close();
        
        return characters;
    }
    
    static int words(File f)
        throws java.io.FileNotFoundException
    {
        Scanner s = new Scanner(f);
        int words = 0;
        
        while (s.hasNext()) {
            s.next();
            words = words + 1;
        }
        
        s.close();
        
        return words;
    }
    
    static int lines(File f)
        throws java.io.FileNotFoundException
    {
        Scanner s = new Scanner(f);
        int lines = 0;
        
        while (s.hasNextLine()) {
            s.nextLine();
            lines = lines + 1;
        }
        
        s.close();
        
        return lines;
    }
}

