/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-00-00

Purpose
=======
To solve the Programming Exercise 10.9 (7e 9.9)

    The `Course` class
    ------------------
    * The array size is fixed in Listing (7e 9.6). Improve it to
      automatically increase the array size by creating a new larger
      array and copying the contents of the current array to it.
    * Implement the `dropStudent` method.
    * Add a new method named `clear()` that removes all student from the
      course.
    
    Write a test program that creates a course, add three students,
    removes one, annd displays the students in the course.

*/

import java.util.Arrays;

/**
 * Driver class
 */
class main {
    public static void main (String[] args) {
        Course course = new Course("MECHA 101 - Giant Robots");
        
        course.addStudent("Simon")
              .addStudent("Kamina")
              .addStudent("Yoko Ritona");
        
        // Well, that was boring.
        // Lets kick it up a notch.
        course.addStudent("Boota")
              .addStudent("Leeron Ritona")
              .addStudent("Kittan Bachika")
              .addStudent("Kiyoh Bachika")
              .addStudent("Kiyal Bachika")
              .addStudent("Kinon Bachika")
              .addStudent("Gimmy Adai")
              .addStudent("Darry Adai")
              .addStudent("Rossiu Adai")
              .addStudent("Dayakka Ritona")
              .addStudent("Tetsukan Ritona")
              .addStudent("Gabal Docker")
              .addStudent("Leite Jokin")
              .addStudent("Zorthy Kanai")
              .addStudent("Iraak Coega")
              .addStudent("Kidd Coega")
              .addStudent("Makken")
              .addStudent("Balinbow Bakusa")
              .addStudent("Jorgun Bakusa")
              .addStudent("Attenborough Cortitch")
              .addStudent("Nia Teppelin");
        // BAM
        
        System.out.println("Initial Roster");
        System.out.println(course);
        
        course.dropStudent("Kamina");
        
        course.dropStudent("Kiyoh Bachika").addStudent("Kiyoh Ritona");
        
        course.dropStudent("Makken")
              .dropStudent("Zorthy Kanai")
              .dropStudent("Iraak Coega")
              .dropStudent("Kidd Coega")
              .dropStudent("Balinbow Bakusa")
              .dropStudent("Jorgun Bakusa")
              .dropStudent("Kittan Bachika")
              .dropStudent("Nia Teppelin");
        
        System.out.println("\nAfterwards...");
        System.out.println(course);
        
        course.clear();
        System.out.println("\nFin.");
        System.out.println(course);
    }
}

/**
 * A simple representation of a class roster.
 * 
 * Stores the course title and a simple list of the names of the
 * students.
 * 
 */
class Course {
    private String courseName;
    private String[] students = new String[2];
    private int enrolled;
    private boolean sorted;
    
    /**
     * Construct a new course with the specified title.
     * 
     * @param String courseName
     * 
     */
    public Course(String courseName) {
        this.courseName = courseName;
    }
    
    /**
     * Add a new student to the course.
     * 
     * Appends new student to the end of the list and increases
     * enrollment count. Marks list as unsorted.
     * 
     * Increases array size if necessary.
     * 
     * @param String student
     * 
     * @return Course -- `this` reference. Generative function.
     * 
     */
    public Course addStudent(String student) {
        // check that there is space in the array.
        if(this.enrolled >= this.students.length) {
            // make a larger array if there isn't.
            
            String[] newArray = new String[(int)(this.enrolled * 1.5)];
            
            for(int i = 0; i < this.enrolled; i++) {
                //System.out.println("    "+this.students[i]);
                
                newArray[i] = this.students[i];
            }
            
            this.students = newArray;
        }
        
        this.students[enrolled] = student;
        this.enrolled = this.enrolled + 1;
        this.sorted = false;
        
        return this;
    }
    
    /**
     * Removes a student from the course roster.
     * 
     * @param String student
     * 
     * @return Course -- `this` reference. Generative function.
     * 
     */
    public Course dropStudent(String student) {
        int index = this.findStudent(student);
        
        if(index >= 0) {
            String[] newData = new String[this.students.length];
            
            int j = 0;
            for(int i = 0; i < this.enrolled; i++) {
                if(i != index) {
                    newData[i-j] = this.students[i];
                } else {
                    j = 1;
                }
            }
            this.enrolled = this.enrolled - 1;
            this.students = newData;
        }
        
        return this;
    }
    
    /**
     * Finds the index of a student by name.
     * 
     * This result will be invalid if another student is added and the
     * list is subsequently sorted!
     * 
     * Name must match exactly: search is performed by built-in
     * Arrays.binarySearch method.
     * 
     * @param String student
     * 
     * @return int index
     * 
     */
    public int findStudent(String student) {
        this.sort();
        return Arrays.binarySearch(this.students, 0, this.enrolled, student);
    }
    
    /**
     * Sorts the student list (if it needs it.)
     * 
     * Sorting is performed by built-in Arrays.sort() method
     * 
     * @return Course -- `this` reference. Generative function.
     * 
     */
    public Course sort() {
        if(!this.sorted) {
            Arrays.sort(this.students, 0, this.enrolled, null);
        }
        
        return this;
    }
    
    /**
     * Clears the course, removing all students, but not the course
     * title.
     * 
     * Also returns the roster array to default length.
     * 
     * @return Course -- `this` reference. Generative function.
     * 
     */
    public Course clear() {
        String[] newData = new String[2];
        
        this.students = newData;
        this.enrolled = 0;
        this.sorted = false;
        
        return this;
    }
    
    /**
     * Creates a human-readable representation of the course.
     * 
     * Result is a restructuredText formatted table containing the
     * course title, number of students, and slots left before the
     * array is increased in the header, as well as each student and
     * the array-index that his name is found at as columns in the
     * table.
     * 
     * @return String
     * 
     */
    public String toString() {
        this.sort();
        
        StringBuilder output = new StringBuilder();
        output.append(String.format(
            "==== ===============================" +
            "====================================\n" +
            "%-36s %35s\n" +
            "------------------------------------" +
            "------------------------------------\n" + 
            "Seat Student Name\n" +
            "==== ===============================" +
            "====================================",
            this.courseName, String.format("Seats %s / %s",
            this.enrolled, this.students.length)));
        
        if(this.enrolled > 0) {
            for(int i = 0; i < this.enrolled; i++) {
                output.append(String.format("\n%04d %s", i, this.students[i]));
            }
        } else {
            output.append(String.format("\n%10s", "emtpy"));
        }
        output.append("\n==== ===============================" +
                        "====================================");
        return output.toString();
    }
}
