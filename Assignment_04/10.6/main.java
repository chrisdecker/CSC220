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
        Course course = new Course("MECHA101 - Giant Robots");
        // Well, that was boring.
        
        // Lets kick it up a notch.
        course.addStudent("Yoko Ritona")
              .addStudent("Simon")
              .addStudent("Kamina")
              .addStudent("Leeron Ritona")
              .addStudent("Kittan Bachika")
              .addStudent("Nia Teppelin")
              .addStudent("Gimmy Adai")
              .addStudent("Darry Adai")
              .addStudent("Balinbow Bakusa")
              .addStudent("Jorgun Bakusa")
              .addStudent("Rossiu Adai")
              .addStudent("Boota")
              .addStudent("Dayakka Ritona")
              .addStudent("Kiyoh Bachika")
              .addStudent("Kiyal Bachika")
              .addStudent("Kinon Bachika")
              .addStudent("Zorthy Kanai")
              .addStudent("Iraak Coega")
              .addStudent("Kidd Coega")
              .addStudent("Makken")
              .addStudent("Attenborough Cortitch")
              .addStudent("Tetsukan Ritona")
              .addStudent("Gabal Docker")
              .addStudent("Leite Jokin");
        // BAM
        
        System.out.println("Initial Roster");
        System.out.println(course);
        
        course.dropStudent("Kamina")
              .dropStudent("Makken")
              .dropStudent("Zorthy Kanai")
              .dropStudent("Balinbow Bakusa")
              .dropStudent("Jorgun Bakusa")
              .dropStudent("Iraak Coega")
              .dropStudent("Kidd Coega")
              .dropStudent("Kittan Bachika");
        
        System.out.println("\nAfterwards...");
        System.out.println(course);
        
    }
}

class Course {
    private String courseName;
    String[] students = new String[100];
    int enrolled;
    boolean sorted;
    
    public Course(String courseName) {
        this.courseName = courseName;
    }
    
    public Course addStudent(String student) {
        // check that there is space in the array.
        if(this.enrolled >= this.students.length) {
            // make a larger array if there isn't.
            //String[] newArray = new String[(int)(this.enrolled * 1.5)];
            //System.arraycopy(this.students, 0, newArray, 0);
            //this.students = newArray;
            
            //Array.copyOf(this.students
            
            return this;
        }
        
        this.students[enrolled] = student;
        this.enrolled = this.enrolled + 1;
        this.sorted = false;
        
        return this;
    }
    
    public Course dropStudent(String student) {
        int index = this.findStudent(student);
        
        if(index >= 0) {
            String[] newData = new String[this.students.length];
            
            // By using a while loop, we have the opportunity to NOT
            // increment the counter. This added to adjusting the limit
            // when we see the student who recently had a bridge
            // dropped on him means that we neatly leave the remains
            // to be taken out by the garbage collector.
            int i = 0;
            while(i < this.enrolled) {
                if(i != index) {
                    newData[i] = this.students[i];
                    i = i + 1;
                } else {
                    this.enrolled = this.enrolled - 1;
                    index = - 1;
                }
            }
            
            this.students = newData;
        }
        
        return this;
    }
    
    public int findStudent(String student) {
        return Arrays.binarySearch(this.students, 0, this.enrolled, student);
    }
    
    public Course sort() {
        if(!this.sorted) {
            QuickSort.Quicksort(this.students, 0, enrolled-1);
            this.sorted = true;
        }
        
        return this;
    }
    
    public String toString() {
        this.sort();
        
        StringBuilder output = new StringBuilder();
        output.append(String.format(
            "========================================\n" +
            "%s\n" +
            "----------------------------------------\n" +
            "%22d students enrolled\n" +
            "========================================",
            this.courseName, this.enrolled));
        
        if(this.enrolled > 0) {
            for(int i = 0; i < this.enrolled; i++) {
                output.append(String.format("\n%s", this.students[i]));
            }
        } else {
            output.append(String.format("\n%s", "emtpy"));
        }
        output.append("\n========================================");
        return output.toString();
    }
}
