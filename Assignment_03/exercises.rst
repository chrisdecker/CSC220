Chapter 9
=========

2.  Suppose `s1` and `s2` are two strings. Which of the following statements or
    expressions are incorrect?
    
    .. code-block:: java
        
        String s = new String("new string"); // Correct
        String s3 = s1 + s2;                 // Correct (concatenation)
        String s3 = s1 - s2;                 // Incorrect (interuptenation?)
        s1 == s2;                            // Correct (but mostly useless)
        s1 >= s2;                            // Correct (but again useless)
        s1.compareTo(s2);                    // Correct
        int i = s1.length();                 // Correct
        char c = s1(0);                      // Correct
        char c = s1.charAt(s1.length());     // Incorrect (index out of bounds)

6.  Suppose string `s` is created using `new String()`; what is `s.length()`?
    
    Zero.

10. How do you determine whether a character is in lowercase or uppercase?
    
    .. code-block:: java
        
        Character.isLowerCase();

14. Write three statements to reverse a string `s` using the reverse method in
    the `StringBuilder` class.
    
    .. code-block:: java
        
        s.reverse();
        s = s.reverse();
        StringBuilder s2 = s.reverse();

18. Show the output of the following program:
    
    .. code-block:: java
        
        public class Test {
            public static void main(String[] args) {
                String s = "Java";
                StringBuilder builder = new StringBuilder(s);
                change(s, builder);
                
                System.out.println(s);
            }
            
            private static void change(String s, StringBuilder builder) {
                s = s + " and HTML";
                builder.append(" and HTML");
            }
        }
    
    ::
        
        Java
    
    String `s` is complex and was passed in by reference, However, concatenating
    strings creates a new string, so the local String variable `s` is given a
    new memory address pointing to the new string data. The orginating variable
    is later printed still containing the original string data.

22. How do you check whether a file already exists? How do you delete a file?
    How do you rename a file/ can you find the file size (the number of bytes)
    using the `File` class?
    
    

26. How do you create a Scanner to read data from a file? What is the reason to
    declare `throws Exception` in the main method in listing (7e 8.7),
    ReadData.java? What would happen if the close method were not invoked in
    Listing (7e 8.7)?
    
    

30. Suppose you enter 45, the ENTER key, 57.8, the ENTER key, 789, the ENTER
    key. Show the contents of the variables after the following code is
    executed.
    
    .. code-block:: java
        
        Scanner input = new Scanner(System.in);
        int intValue = input.nextInt();
        double doubleValue = input.nextDouble();
        String line = input.nextLine();
    
    =========== =====
    Variable    Value
    =========== =====
    intValue    45   
    doubleValue 57.8 
    line        "789"  
    =========== =====

