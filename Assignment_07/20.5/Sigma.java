/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-00-00

20.5 - Summing a series
=======================
Write a recursive method to compute the following series::
    
            1     2     3     4      5      6             i
    m(i) = --- + --- + --- + --- + ---- + ---- + ... + ------
            3     5     7     9     11     13           2i+1

OpenOffice.org Formula::
    
    m(i) ~=~ 1 over 3 ~+~ 2 over 5 ~+~ 3 over 7 ~+~ 4 over 9 ~+~
    5 over 11 ~+~ 6 over 13 ~+~ dotsaxis ~+~ i over {2i + 1}

*/

/**
 * Driver class
 */
public class Sigma {
    Function fn;
    
    public static void main (String[] args) {
        Function f = new Function() {
            public double function(double ... arguments) {
                if(arguments.length >= 1) {
                    double i = arguments[0];
                    return i / (3 * i + 1);
                }
            }
        };
        
        Sigma s = new Sigma(f);
        
        System.out.println(s.summation(1,10));
        
    }
    
    public Sigma(Function f) {
        this.fn = f;
    }
    
    public double summation(int index, int limit) {
        if(index <= limit) {
            return fn.function(index) + this.summation(index+1, limit);
        } else {
            return 0;
        }
    }
}

/**
 * Quick parent class for passing a function definition into Sigma.
 * 
 */
class Function {
    public double function(double ... arguments) {
        return 1;
    }
}
