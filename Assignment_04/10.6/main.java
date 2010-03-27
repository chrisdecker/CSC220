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
        
        System.out.println(course.findStudent("Kamina"));
        
        
        //course.dropStudent("Kamina");
        
        //for(int i = 0; i < course.enrolled; i++) {
        //    System.out.printf("course.students[%d] = %s\n", i, course.students[i]);
        //}
        
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
            // dropped on him means that we neatly leave the poor soul
            // out of the new array while simultaneously correcting the
            // student count.
            int i = 0;
            while(i < this.enrolled) {
                
                if(i != index) {
                    newData[i] = this.students[i];
                    i = i + 1;
                } else {
                    this.enrolled = this.enrolled - 1;
                }
            }
        }
        
        return this;
    }
    
    public int findStudent(String student) {
        // List of one is default sorted and list of zero has no
        // results. Short-circuit the entire function for special cases.
        if(this.enrolled < 1) {
            return -1;
        } else if(this.enrolled == 1) {
            return 0;
        }
        
        // Ensure a sorted listing of students for binary search.
        this.sort();
        
        // bootstrap the search with some initial data.
        int min = 0;
        int max = enrolled;
        
        // start at the middle and make the initial comparison. We can
        // skip the loop if we are lucky.
        int index = enrolled / 2;
        int found = student.compareTo(this.students[index]);
        
        while (found != 0) {
            
            System.out.printf("Range: %d, %d; Next: %d\n",
                min, max, (min+max)/2);
            //System.out.printf("Checking: %d\n", index);
            
            if(found < 0) {
                max = index;
                //System.out.printf("lower: %d\n", max);
            } else {
                min = index;
                //System.out.printf("higher: %d\n", min);
            }
            
            // A simple less than check won't work. We also need to
            // check that there is another element to compare between
            // min and max.
            // 
            // Both checks can be combined.
            // If min is already larger or suffifiently less than, one
            // more won't change that. But if it's just one less, then
            // the addition pushes it over the less than and fails.
            if(!((min+1) < max)) {
                return -1;
            }
            
            // next element and comparison.
            index = (min + max) / 2;
            found = student.compareTo(this.students[index]);
        }
        
        return index;
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
        
        if(this.enrolled > 0) {
            StringBuilder output = new StringBuilder();
            
            output.append(this.courseName);
            
            for(int i = 0; i < this.enrolled; i++) {
                output.append("\n");
                output.append(this.students[i]);
            }
            
            return output.toString();
        }
        
        return "";
    }
}
