Chapter 9
=========

2.  Suppose `s1` and `s2` are two strings. Which of the following statements or
    expressions are incorrect?
    
    .. code-block:: java
        
        String s = new String("new string");
        String s3 = s1 + s2;
        String s3 = s1 - s2;
        s1 == s2;
        s1 >= s2
        s1.compareTo(s2);
        int i = s1.length();
        char c = s1(0);
        char c = s1.charAt(s1.length());
    
    

6.  Suppose string `s` is created using `new String()`; what is `s.length()`?
    
    

10. How do you determine whether a character is in lowercase or uppercase?
    
    

14. Write three statements to reverse a string `s` using the reverse method in
    the `StringBuilder` class.
    
    

18. Show the output of tthe following program:
    
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
    
    

