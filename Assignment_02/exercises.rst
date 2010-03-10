Chapter 8
=========

2.  Describe the relationship between an object and it's defining class. How do
    you declare a class? How do you declare an object reference variable? How do
    you create an object? How do you declare and create an object in one
    statement?
    
    An object is a instantiation of a single class representing exactly one of
    its kind.
    
    .. code-block:: java
        
        // Declare a class
        class Mecha {
        }
    
        // Create an object reference variable
        Mecha Lagann;
    
        // Create an object
        new Mecha();
    
        // Declare and Create in one statement
        Mecha GurrenLagann = new Mecha();

4.  What is wrong with the following program[s]?
    
    .. code-block:: java
        
        // (a)
        
        public class ShowErrors {
            public static void main(String[] args) {
                ShowErrors t = new ShowErrors(5);
            }
        }
    
    There's no constructor to accept the integer argument.
    
    .. code-block:: java
        
        // (b)
        
        public class ShowErrors {
            public static void main(String[] args) {
                ShowErrors t = new ShowErrors();
                t.x();
            }
        }
    
    Method `ShowErrors.x()` doesn't exist.
    
    .. code-block:: java
        
        // (c)
        
        public class ShowErrors {
            public void method1() {
                Circle c;
                System.out.println("What is radius "
                    + c.getRadius());
                c = new Circle();
            }
        }
    
    `c` is a null pointer until initialized. Calling any instance method or
    instance attribute before initializing the object will fail.
    
    .. code-block:: java
        
        // (d)
        
        public class ShowErrors {
            public static void main(String[] args) {
                C c = new C(5.0);
                System.out.println(c.value);
            }
        }
        
        class C {
            int value = 2;
        }
    
    No constructor to handle the floating value provided.

6.  What is the printout of the following code?
    
    .. code-block:: java
        
        public class Foo {
            private boolean x;
            
            public static void main(String[] args) {
                Foo foo = new Foo();
                System.out.println(foo.x);
            }
        }
    
    .. code-block:: java
        
        false
    

8.  How do you create a JFrame, set a title in the frame, and display a frame?
    
    

10. Suppose class `Foo` is defined in (a). Let f be an instance of `Foo`. Which
    of the statements in (b) are correct?
    
    .. code-block:: java
        
        // (a)
        
        public class Foo {
            int i;
            static String s;
            
            void imethod() {
            }
            
            static void smethod() {
            }
        }
    
    .. code-block:: java
        
        System.out.println(f.i);   // Correct
        System.out.println(f.s);   // Correct
        f.imethod();               // Correct
        f.imethod();               // Correct
        System.out.println(Foo.i); // Incorrect (not a static class attribute)
        System.out.println(Foo.s); // Correct
        Foo.imethod();             // Incorrect (not a static method)
        Foo.smethod();             // Correct
    
    

12. Can you invoke an instance method or reference an instance variable from a
    static method? Can you invoke a static method or reference a static variable
    from an instance method? What is wrong in the following code?
    
    .. code-block:: java
        
        public class Foo {
            public static void main(String[] args) {
                method1();
            }
            
            public void method1() {
                method2();
            }
            
            public static void method2() {
                System.out.println("What is radius " + c.getRadius());
            }
            
            Circle c = new Circle();
        }
    
    `Foo.method1` is an instance method and cannot be called from a static
    method.
    
    Instance method or variable from static method
        No.
    
    Static method or variable from instance method
        Yes.
    
    

14. What are the benefits of data encapsulation?

16. Describe the difference between passing a parameter of a primitive type and
    passing a parameter of a reference type. Show the output of the following
    program:
    
    .. code-block:: java
        
        public class Test {
            public static void main(String[] args) {
                Count myCount = new Count();
                int times = 0;
                
                for(int i = 0; i < 100; i++) {
                    increment(myCount, times);
                }
                
                System.out.println("count is " + myCount.count);
                System.out.println("times is " + times);
            }
            
            public static void increment(Count c, int times) {
                c.count++;
                times++;
            }
        }
    
    .. code-block:: java
        
        public class Count {
            public int count;
            
            Count(int c) {
                count = c;
            }
            
            Count() {
                count = 1;
            }
        }
    
    ::
        
        count is 101
        times is 0
    
    The difference between passing a primitive-type argument and a
    reference-type argument is that reference-type arguments are pointers to a
    location in memory. This pointer is a primitive-type and is passed by value
    into and reconstructed during entry into the function, where it points to
    the same location in memory as the original variable.
    
    Since both the argument inside the function and the variable outside the
    function point to the same memory location, changes made to one are
    reflected in the other.

18. Show the printout of the following code:
    
    .. code-block:: java
        
        // (a)
        
        public class Test {
            public static void main (String[] args) {
                int[] a = {1,2};
                swap(a[0], a[1]);
                System.out.println("a[0] = " + a[0] 
                    + " a[1] = " + a[1]);
            }
            
            public static void swap(int n1, int n2) {
                int temp = n1;
                n1 = n2;
                n2 = temp;
            }
        }
    
    ::
        
        a[0] = 1 a[1] = 2
    
    .. code-block:: java
        
        // (b)
        
        public class Test {
            public static void main (String[] args) {
                int[] a = {1,2};
                swap(a);
                System.out.println("a[0] = " + a[0] 
                    + " a[1] = " + a[1]);
            }
            
            public static void swap(int[] a) {
                int temp = a[0];
                a[0] = a[1];
                a[1] = temp;
            }
        }
    
    ::
        
        a[0] = 2 a[1] = 1
    
    .. code-block:: java
        
        // (c)
        
        public class Test {
            public static void main (String[] args) {
                T t = new T();
                swap(t);
                System.out.println("e1 = " + t.e1 
                    + " e2 = " + t.e2);
            }
            
            public static void swap(T t) {
                int temp = t.e1;
                t.e1 = t.e2;
                t.e2 = temp;
            }
        }
        
        class T {
            int e1 = 1;
            int e2 = 2;
        }
    
    ::
        
        e1 = 2 e2 = 1
    
    .. code-block:: java
        
        // (d)
        
        public class Test {
            public static void main (String[] args) {
                T t1 = new T();
                T t2 = new T();
                System.out.println("t1's i = " + t1.i
                    + " and j = " + t1.j);
                System.out.println("t2's i = " + t2.i
                    + " and j = " + t2.j);
            }
        }
        
        class T {
            static int i = 0;
            int j = 0;
            
            T() {
                i++;
                j = 1;
            }
        }
    
    ::
        
        t1's i = 2 and j = 1
        t2's i = 2 and j = 1

20. What is wrong with the following code?
    
    .. code-block:: java
        
        public class Test {
            public static void main(String[] args) {
                java.util.Date[] dates = new java.util.Date[10];
                System.out.println(dates[0]);
                System.out.println(dates[0].toString());
            }
        }
    
    ::
        
        null
        Exception in thread "main" java.lang.NullPointerException
	            at Test.main(Test.java:5)
    
    Making an array of an object type doesn't actually instantiate those
    objects. The array is filled with 10 java.util.Date typed null pointers
    rather than pointers to 10 different java.util.Date objects.
    
    .. code-block:: java
        
        public class Test {
            public static void main(String[] args) {
                java.util.Date[] dates = new java.util.Date[10];
                
                // Instantiate the array of dates.
                for(int i = 0; i < dates.length; i++) {
                    dates[i] = new java.util.Date();
                }
                
                System.out.println(dates[0]);
                System.out.println(dates[0].toString());
            }
        }
    
    ::
        
        Wed Mar 10 02:07:24 PST 2010
        Wed Mar 10 02:07:24 PST 2010

