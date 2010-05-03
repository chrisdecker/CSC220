Chapter 16
==========
1.  Can a button fire a ``WindowEvent``? Can a button fire a
    ``MouseEvent``? Can a button fire an ``ActionEvent``?
    
    No, no, and yes.

2.  Why must a listener be an instance of an appropriate listener
    interface? Explain how to register a listener object and how to
    implement a listener interface.
    
    The listener must be the right interface because the code that
    calls the methods in the listener calls certain names. If you
    somehow put a ``MouseMotionListener`` where an ``ActionEvent``
    should be, the event engine would attempt to call
    ``actionPerformed`` method of the ``MouseMotionListener``,
    which will fail.
    
    You can register a listener with the appropriate register method
    for the listener's interface. For example, ``addActionListener``
    for ``ActionListener``s.
    
    Creating an action listener requires implementing the correct
    interface with a concrete class, whihc can be done as an outer
    class, and inner class, or an anonymous class.

3.  Can a source have multiple listeners? Can a listener listen on
    multiple sources? Can a source be a listener for itself?
    
    Can a source have multiple listeners?
        Yes.
    
    Can a listener listen on multiple sources?
        Yes.
    
    Can a source be a listener for itself?
        Yes.

4.  How do you implement a method defined in the listener interface? Do
    you need to implement all the methods defined in the listener
    interface?
    
    How do you implement a method defined in the listener interface?
        Implement the interface in a subclass and define the methods
        it requires.
    
    Do you need to implement all the methods defined in the listener interface?
        Yes.

5.  Can an inner class be used in a class other than the class in which
    it nests?
    
    Yes.

6.  Can the modifiers ``public``, ``private``, and ``static`` be used
    on inner classes?
    
    Yes.

7.  If class ``A`` is an inner class in class ``B``, what is the .class
    file for ``A``? If class B contains two anonynmous inner classes,
    what are the .class file names for these two classes?
    
    ``B$A.class``, ``B$1.class``, and ``B$2.class``, respectively.

9.  What is wrong in the following code?
    
    .. code-block:: java
        
        import javax.swing.*;
        import java.awt.*;
        
        public class Test extends JFrame {
            public Test() {
                JButton jbtOK = new JButton();
                add(jbtOK);
            }
            
            private class Listener implements ActionListener {
                public void ActionPerform(ActionEvent e) {
                    System.out.println(jbtOK.getActionCommand());
                }
            }
            
            /** Main method omitted */
        }
    
    * Does not import ``java.awt.event``, but uses that package's
      contents.
    * Attempts to reference a variable in the constructor from an inner
      class.
    * Fails to properly implement the ActionListener interface (or at
      least that's what ``javac`` is telling me. Not sure *why*...)
    
    .. code-block:: java
        
        import java.awt.event.*;
        import javax.swing.*;
        
        public class Test extends JFrame {
            public Test() {
                JButton jbtOk = new JButton();
                add(jbtOK);
                jbtOK.addActionListener(new ActionListener () {
                    public void ActionPerformed(ActionEvent e) {
                        System.out.println(jbtOK.getActionCommand());
                    }
                } // Something missing here
            
            /** Main method omitted */
        }
    
    

11. What is the listener interface for mouse pressed, released,
    clicked, entered, and exited? What is the listener interface for
    mouse moved and dragged?
    
    

13. Is the ``KeyPressed`` handler invoked after a key is pressed? Is
    the ``KeyReleased`` handler invoked after a key is released? Is the
    ``KeyTyped`` handler invoked after *any* key is typed?
    
    

14. How do you create a timer? How do you start a timer? How do you
    stop a timer?
    
    

15. Does the ``Timer`` class have a no-arg constructor? Can you add
    multiple listeners to a timer?
    
    

Chapter 19
==========
1.  What is a text file, and what is a binary file? Can you view a text
    file or a binary file using a text editor?
    
    

5.  If you write a string "ABC" to an ASCII text file, what values are
    stored in the file?
    
    

9.  Why should you always close streams?
    
    

13. How do you append data to an existing text file using
    ``java.io.PrintWriter``?
    
    

17. What is wrong in the following code?
    
    .. code-block:: java
        
        import java.io.*;
        
        public class Test {
            public static void main(String[] args) {
                try {
                    FileInputStream fis = new FileInputStream("test.dat");
                } catch(IOException ex) {
                    ex.printStackTrace();
                } catch(FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
    
    

21. What are the advantages of using buffered streams? Are the
    following statements correct?
    
    .. code-block:: java
        
        BufferedInputStream input1 =
            new BufferedStream(new FileInputStream("t.dat"));
        
        DataInputStream input2 =
            new DataInputStream(new FileInputStream("t.dat"));
        
        ObjectInputStream input3 =
            new ObjectInputStream(new FileInputStream("t.dat"));
    
    

25. Can you write an array to an ``ObjectOutputStream``?
    
    

29. Create a ``RandomAccessFile`` stream for the file **address.dat**
    to allow the updating of student information in the file. Create a
    ``DataOutputStream`` for the file **address.dat**. Explain the
    differences between these two statements.
    
    

Chapter 20
==========
1.  What is a recursive method? Describe the characteristics of
    recursive methods. What is an infinite recursion?
    
    

2.  Write a recursive mathematical definition for computing
    2\ :sup:`n` for a positive integer *n*.
    
    

3.  Write a recursive mathematical definition for computing
    *x*\ :sup:`n` for a positive integer *n* and real number *x*.
    
    

4.  Write recursive mathematical definition for computing
    1 + 2 + 3 + ... + *n* for a positive integer *n*.
    
    

5.  How many times is the ``factorial`` method in Listing (7e 20.1)
    invoked for ``factorial(6)``?
    
    

6.  How many times is the ``fib`` method in Listing (7e 20.2) invoked
    for ``fib(6)``.
    
    

7.  Show the call stack for ``isPalindrome("abcba")`` using the
    methods declared in Listing (7e 20.3) and Listing (7e 20.4),
    respectively.
    
    

8.  Show the call stack for
    ``selectionSort(new double[] {2, 3, 5, 1})`` using the method
    declared in Listing (7e 20.5).
    
    

9.  What is a recursive helper function?
    
    

10. How many times is the ``moveDisks`` method in Listing (7e 20.8)
    invoked for ``moveDisks(5, 'A', 'B', 'C')``?
    
    

11. Which of the following statemtents are true?
    
    * Any recursive method can be converted into a nonrecursive method.
    * Recursive methods take more time and memory to execute than
      nonrecursive methods.
    * Recursive methods are *always* simpler than nonrecursive methods.
    * There is always a condition statement in a recursive method to
      check whether a base case is reached.
    
    

12. What is the cause for a stack overflow exception?
    
    

