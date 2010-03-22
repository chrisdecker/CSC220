/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-00-00

Purpose
=======
To solve Programming Exercise 9.23 (7e 8.23)

    Implementing the String class
    -----------------------------
    The String class is provided in the Java library. Provide your own
    implementation for the following methods (name the new class MyString1)::
        
        public MyString1(char[] chars);
        public char charAt(int index);
        public int length();
        public MyString1 substring(int begin, int end);
        public char[] toChars();
        public MyString1 toLowerCase();
        public boolean equals(MyString1 s);
        public static MyString1 valueOf(int i);

Document History
================
============= ==================================================================
Date Modified Reason
============= ==================================================================
2010-00-00    Document Created
============= ==================================================================

*/

/**
 * Driver class
 */
class main {
    public static void main (String[] args) {
        char[] c = {'Z','e','T','s','u','B','o'};
        MyString1 s = new MyString1(c);
        
        System.out.print("Verify contents: ");
        s.print();
        System.out.print("\n\n");
        
        // indexing
        System.out.print("MyString1.charAt(int index): ");
        System.out.println(s.charAt(3));
        
        // string length
        System.out.print("MyString1.length(): ");
        System.out.println(s.length());
        
        // substring
        System.out.print("MyString1.substring(int begin, int end): ");
        s.substring(2,5).print();
        System.out.print("\n");
        
        // to character array
        System.out.print("MyString1.toChars(): ");
        System.out.println(s.toChars());
        
        // to lower case
        System.out.print("MyString1.toLowerCase(): ");
        s.toLowerCase().print();
        System.out.print("\n");
        
        // equals
        char[] c2 = {'Z','e','t','s','u','b','o'};
        MyString1 s2 = new MyString1(c2);
        char[] c3 = {'Z','e','T','s','u'};
        MyString1 s3 = new MyString1(c3);
        System.out.println("MyString1.equals(): ");
        
        // this is why you use built-ins. When you start re-implementing things,
        // the normal methods don't work with them. At least they could be made
        // to work in a duck-typed language...
        System.out.print("    ");
        s.print();
        System.out.print(" == ");
        s.print();
        System.out.print(" ? ");
        System.out.println(s.equals(s));
        System.out.print("    ");
        s.print();
        System.out.print(" == ");
        s2.print();
        System.out.print(" ? ");
        System.out.println(s.equals(s2));
        System.out.print("    ");
        s.print();
        System.out.print(" == ");
        s3.print();
        System.out.print(" ? ");
        System.out.print(s.equals(s3));
        System.out.print("\n");
        
        // convert Integer to MyString1
        MyString1.valueOf(34).print();
        System.out.print("\n");
    }
}

class MyString1 {
    char[] __data;
    
    public MyString1(char[] chars) {
        // If you don't clone the array, the data will remain available outside
        // the class.
        this.__data = new char[chars.length];
        System.arraycopy(chars, 0, this.__data, 0, chars.length);
    }
    
    public MyString1 print() {
        for(int i = 0; i < this.length(); i++) {
            System.out.print(this.__data[i]);
        }
        
        return this;
    }
    
    public char charAt(int index) {
        // String class throws StringIndexOutOfBoundsException in the event of
        // an out-of-bounds index. I'm not going to subclass Exception, so I'm
        // sticking with the normal ArrayIndexOutOfBoundsException thrown in the
        // same case here.
        return this.__data[index];
    }
    
    public int length() {
        return this.__data.length;
    }
    
    public MyString1 substring(int begin, int end) {
        char[] substring = new char[end-begin];
        
        for(int i = begin; i < end; i++) {
            substring[i-begin] = this.charAt(i);
        }
        
        return new MyString1(substring);
    }
    
    public char[] toChars() {
        char[] ch = new char[this.length()];
        System.arraycopy(this.__data,0,ch,0, this.length());
        return ch;
    }
    
    public MyString1 toLowerCase() {
        char[] ch = this.toChars();
        
        for(int i = 0; i < this.length(); i++) {
            ch[i] = Character.toLowerCase(ch[i]);
        }
        
        return new MyString1(ch);
    }
    
    public boolean equals(MyString1 s) {
        if(this.length() != s.length()) {
            return false;
        }
        
        for(int i = 0; i < this.length(); i++) {
            if(this.charAt(i) != s.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    
    public static MyString1 valueOf(int i){
        return new MyString1(Integer.toString(i).toCharArray());
    }
    
}
