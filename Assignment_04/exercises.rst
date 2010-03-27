Chapter 10
==========

1.  If a class contains only private data fields and no set methods, is
    the class immutable?
    
    Only if it also does not return references to mutable data fields.

2.  If all the data fields in a class are private and primitive types,
    and the class contains no `set` methods, is the class immutable?
    
    Yes. It is impossible to return references to primitive types in
    Java, so the requirement that no references to mutable data fields
    is implicit.

3.  Is the following class immutable?
    
    .. code-block:: java
        
        class A {
            private int[] values;
            
            public in[] getValues() {
                return values;
            }
        }
    
    No. `A.in()` returns a reference to `A.values`, which can be
    modified outside the class.

4.  If you redefine the `Loan` class in the preceeding chapter without
    `set` methods, is the class immutable?
    
    No. That class also includes `Loan.getLoanDate():java.util.Date`,
    providing a reference to the mutable data field `loanDate`.

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
    
    ::
        
        i + j is 23
        k is 2
        j is 0
    
    Be careful with type converting operators. Sometimes they do weird
    things. Like concatenating two integers instead of adding them.


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
    
    The `this` keyword is a static reference to the instance of the
    class calling an instance method. It is used to allow the
    programmer (and anyone reading the code!) to be certain of the
    scope of the variables--any variable referenced through the `this`
    keyword is guaranteed to be an instance variable and not a local
    or argument.
    
    Leading me to what is wrong in the code above, which is exactly
    that: In the parameter constructor there is an argument `p` and the
    instance variable of the same name. The same problem is found in
    `C.setP()`. Even if the compiler could correctly guess which label
    refers to which variable, the statement itself is ambiguous.

