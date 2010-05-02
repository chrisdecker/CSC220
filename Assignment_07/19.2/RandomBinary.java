/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-00-00

19.2 - Creating a binary data file
==================================
Write a program to create a file named ``Exercise_19_2.dat`` if it does
not exist. Append new data to it. Write 100 integers created randomly
into the file using binary I/O.

*/

import java.io.FileOutputStream;

/**
 * Driver class
 */
class RandomBinary {
    public static void main (String[] args)
        throws java.io.IOException
    {
        FileOutputStream out = new FileOutputStream("Exercise_19_2.dat");
        for(int i = 0; i < 100; i++) {
            int random = (int)(Math.random() * 256);
            System.out.println(random);
            out.write(random);
        }
    }
}

