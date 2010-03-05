/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-03-02

Purpose
=======
Solution to Programming Exercise 6.24:

    Adding two Matrices
    
    Write a method to add two matrices. The header of the method is as follows:
    
    .. code-block:: java
        
        public static in[][] addMatrix(int[][] a, int[][] b)
    
    In order to be added, the two matrices must have the same dimensions and the
    same or compatible types of elements. As shown below, two matrices are added
    by adding the two elements in each matrix with the same index.

Oh, by the way, the previous class had us do 6.25 (matrix multiplication,) so
I'm building off of previous effort here. I was intending on making a Matrix
object at some point for that assignment but never got around to it. Don't
expect me to whip up custom objects or types for future assignments unless they
are explicitly called for.

Document History
================
============= ==================================================================
Date Modified Reason
============= ==================================================================
2010-03-02    Document Created
============= ==================================================================

*/

/**
 * Driver class
 */
class main {
    public static void main (String[] args) {
        int[][] a_src = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };
        
        int[][] b_src = {
            {-1, 0,-1},
            { 0, 1, 0},
            {-1, 0,-1}
        };
        
        Matrix a = new Matrix(a_src);
        
        Matrix b = new Matrix(b_src);
        
        // Matrix c = a + b; // Yay, no operator overloading in java.
        Matrix c = a.add(b);
        
        System.out.print("\n");
        System.out.print(a.str());
        System.out.print("\n+\n");
        System.out.print(b.str());
        System.out.print("\n=\n");
        System.out.print(c.str());
        System.out.print("\n");
    }
}

/**
 * Represents a two dimensional matrix.
 */
class Matrix {    
    int[][] elements;
    
    int width;
    
    int height;
    
    Matrix(int[][] elements) {
        this.elements = elements;
        
        this.height = this._height();
        this.width = this._width();
    }
    
    /**
     * Returns the height of the matrix
     * 
     * This is run on construction and the result stored in Matrix.height, so
     * use this function only if a recalculation is necessary. For example, if
     * you replaced the contents of the matrix instead of making a new one
     * (don't do that.)
     * 
     * @param int[][] matrix
     * 
     * @return height
     */
    public int _height() {
        return this.elements.length;
    }
    
    /**
     * Returns the width of the matrix.
     *
     * Counts length of each row-array in the matrix. If the matrix is ragged,
     * returns -1. If the matrix is rectangular returns the number of
     * elements in each row-array.
     * 
     * This is run on construction and the result stored in Matrix.width, so use
     * this function only if a recalculation is necessary. For example, if you
     * replaced the contents of the matrix instead of making a new one (don't
     * do that.)
     * 
     * @param int[][] matrix
     * 
     * @return width or -1
     * 
     */
    public int _width() {
        int count = 0;
        
        for (int i = 0; i < this.elements.length; i++) {
            if(count != 0 && this.elements[i].length != count) {
                return -1;
            } else {
                count = this.elements[i].length;
            }
        }
        return count;
    }
    
    /**
     * Performs a simple check of the validity of the matrix (height and width
     * greater than one,) and returns the result.
     * 
     * @return boolean valid
     *  
     */
    public boolean is_valid() {
        return (this.height >= 1) && (this.width >= 1);
    }
    
    /**
     * Add a Matrix object to this one and return a new Matrix object
     * containing the new element values.
     * 
     * Both Matrices must be valid and of the same dimensions. An
     * IllegalArgumentException will be thrown if this is not the case.
     * 
     * @param Matrix other
     * 
     * @return Matrix result
     * 
     */
    public Matrix add(Matrix other) {
        if (!(this.is_valid() && other.is_valid())) {
            throw new IllegalArgumentException("One or both matrices are " +
                "invalid. Usually this is due to the matrix being ragged.");
        }
        
        if(!(this.height == other.height && this.width == other.width)) {
            throw new IllegalArgumentException("Matrix addition requires two "+
                "matrixes of identical dimensions.");
            // actually, that isn't true. There is another type of matrix
            // addition that makes a matrix with a width of the sum of the
            // widths and height of the sum of the heights of the source
            // matrices.
            // In that form, the first source matrix is in the upper left corner
            // of the resulting matrix, while the second source matrix is in the
            // lower right corner.
        }
        
        int height = this.height;
        int width = this.width;
        
        int[][] result_src = new int[height][width];
        
        // loop through all the elements and add each corresponding pair
        // together to get the result element.
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                result_src[i][j] = this.elements[i][j] + other.elements[i][j];
            }
        }
        
        Matrix result = new Matrix(result_src);
        
        return result;
    }
    
    /**
     * Builds a human readable representation of the matrix.
     * 
     * @return String
     * 
     */
    public String str() {
        String output = "\n";
        
        for(int i = 0; i < this.height; i++) {
            output += "[[ ";
            output += String.format("%3d", this.elements[i][0]);
            for(int j = 1; j < this.width; j++) {
                output += String.format(" %3d", this.elements[i][j]);
            }
            output += " ]]\n";
        }
        
        return output;
    }
}

