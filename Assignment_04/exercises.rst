Chapter 10
==========

1.  If a class contains only private data fields and no set methods, is
    the class immutable?
    
    

2.  If all the data fields in a class are private and primitive types,
    and the class contains no `set` methods, is the class immutable?
    
    

3.  Is the following class immutable?
    
    .. code-block:: java
        
        class A {
            private int[] values;
            
            public in[] getValues() {
                return values;
            }
        }
    
    

4.  If you redefine the `Loan` class in the preceeding chapter without
    `set` methods, is the class immutable?
    
    

5.  What is the output of the following program?
    
    .. code-block:: java
        
        public class Foo {
            static int i = 0;
            static int j = 0;
            
            public static void main(String[] args) {
                int i = 2;
                int k = 3;
                
                {
                    int j = 3;
                    System.out.println("i + j is " + i + j);
                }
                
                k = i + j;
                System.out.println("k is " + k);
                System.out.println("j is " + j);
            }
        }
    
    


6.  Describe the role of the `this` keyword. What is wrong  in the
    following code?
    
    .. code-block:: java
        
        public class C {
            int p;
            
            public C() {
                System.out.println("C's no-arg constructor invoked");
                this(0);
            }
            
            public C(int p) {
                p = p;
            }
            
            public void setP(int p) {
                p = p;
            }
        }
    
    

