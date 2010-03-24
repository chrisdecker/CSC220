/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-00-00

Purpose
=======
To solve the Programming Exercise 10.3 (7e 9.3)

    The MyPoint class
    -----------------
    Design a class named MyPoint to represent a point with x- and
    y-coordinates. The class contains:
    
    * Two data fields x and y that represent the coordinates with get
      methods
    * A no-arg constructor that creates a point at (0, 0).
    * Two get methods for data fields x and y respectively.
    * A method named distance that returns the distance from this point
      to another point of the MyPoint type.
    * A method named distance that returns the distance from this point
      to another point with specified x- and y-coordinates.
    
    Draw the UML diagram for the class. Implement the class. Write a
    test program that creates two points (0, 0) and (10, 30.5) and
    displays the distance between them.

*/

/**
 * Driver class
 */
public class main {
    public static void main (String[] args) {
        MyPoint a = new MyPoint(0, 0);
        MyPoint b = new MyPoint(10, 30.5);
        
        System.out.printf(
            "The distance between the points %s and %s is %f.\n",
            a, b, b.distance(a));
    }
}

class MyPoint {
    double __x;
    double __y;
    
    public MyPoint() {
        this(0, 0);
    }
    
    public MyPoint(double x, double y) {
        this.__x = x;
        this.__y = y;
    }
    
     /**
     * Calculate the distance between this instance of MyPoint and the
     * provided coordinates.
     * 
     */
    public double distance(double x, double y) {
        // d = sqrt((x2 - x1)^2 + (y2 - y1)^2)
        return Math.sqrt(
            (x - this.__x)*(x - this.__x) +
            (y - this.__y)*(y - this.__y));
    }
    
    /**
     * Calculate the distance between this and another instance of
     * MyPoint.
     * 
     * Calls the other MyPoint instance's distance(double, double)
     * method with the calling instance's coordinates. 
     * I.E: `p1.distance(p2)` * is equivalent to
     * `p2.distance(p1.__x, p1.__y)`.
     * 
     */
    public double distance(MyPoint other) {
        return other.distance(this.__x, this.__y);
    }
    
    /**
     * Distance from (0, 0)
     * 
     */
    public double distance() {
        return this.distance(0.0, 0.0);
    }
    
    /**
     * Returns a constructor statement for this instance of MyPoint.
     * 
     */
    public String __repr__() {
        return String.format("MyPoint(%f, %f)", this.__x, this.__y);
    }
    
    /**
     * Returns a human readable representation of MyPoint.
     * 
     */
    public String toString() {
        return String.format("(%f, %f)", this.__x, this.__y);
    }
    
    /**
     * Completely pointlessly fetch the x-coordinate of MyPoint.
     * 
     */
    //public double getX() {
    //    return this.__x;
    //}
    
    /**
     * Completely pointlessly fetch the y-coordinate of MyPoint.
     * 
     */
    //public double getY() {
    //    return this.__y;
    //}
}
