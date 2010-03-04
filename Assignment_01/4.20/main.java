/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-03-02

Purpose
=======
Solution to Programming Exercise 4.20:

    Printing Prime Numbers Between 2 and 1000.
    
    Modify Listing 4.14 to print all the prime numbers between 2 and 1000,
    inclusively. Display eight prime numbers per line.

Oh, oops. "Modify Listing 4.14." Ah well. I already wrote the thing to sieve
the primes instead of brute force them, so I'll just stick with this. :P

Ah, by the way, the loop testing for primes in 4.14 goes from 2 to half the
number. It should go from 2 to the square root of the number. Doing this saves
some 21096 iterations over the course of searching primes less than or equal
to 1000:

.. code-block:: python
    
    >>> sum([x/2 for x in xrange(2,1001)])
    250000
    >>> sum([math.sqrt(x) for x in xrange(2,1001)])
    21096.455887480734

Document History
================
============= ==================================================================
Date Modified Reason
============= ==================================================================
2010-03-02    Document Created
2010-03-04    Prime sieve completed.
2010-03-04    Printing completed.
============= ==================================================================
*/

/**
 * Driver class
 */
class main {
    public static void main (String[] args) {
        final int limit = 1000;
        
        main.print(Prime.sieve(limit));
    }
    
    public static void print(boolean[] primes) {
        int counter = 0;
        for (int i=0; i < primes.length; i++) {
            if (primes[i]) {
                System.out.printf("%9d", i);
                
                if (counter % 8 == 7) {
                    System.out.print("\n");
                }
                
                counter = counter + 1;
            }
            
        }
        
        System.out.print("\n");
        
    }
}

/**
 * Prime Generator
 */
class Prime {
    
    /**
     * Generate a list of primes up to the provided limit via the Sieve of
     * Eratosthenes.
     * 
     * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     * 
     * There are some optimizations that could be made to the sieve, but I'm
     * not going to waste effort on it here.
     * 
     * @param int limit
     * 
     * @returns boolean[] index_isprime
     * 
     */
    public static boolean[] sieve (int limit) {
        
        limit = limit + 1; // offset limit to correct for 0-indexed array
        
        boolean[] primes = new boolean[limit];
        
        for (int i=0; i<limit; i++) {
            // Assume all integers greater than 2 are prime.
            primes[i] = i > 1;
        }
        
        // This is the loop that run through the list and determines which are
        // prime. It stops when the square of the current prime exceeds the
        // limit.
        for(int p=2; Math.pow(p, 2) < limit; p++) {
            //System.out.printf("Checking %d... ", p);
            
            // If p is composite, who don't need to strike it's multiples.
            if (primes[p]) {
                //System.out.printf("%d is prime. Strike multiples:\n", p);
                
                // Strike all multiples of p
                for (int q = 2; q < limit; q++) {
                    int n = p*q;
                    
                    if (n < limit) {
                        //System.out.printf("    %d\n", n);
                        
                        primes[n] = false;
                    }
                }
            } else {
                //System.out.printf("%d is not prime. Continuing.\n", p);
            }
        }
        
        // Complete. The array holds true for all prime indexes and false for
        // all composite indexes.
        
        return primes;
    }
    
    
}
