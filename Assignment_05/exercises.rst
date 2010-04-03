Chapter 12
==========

2.  Explain the differences between AWT GUI components, such as
    `java.awt.Button`, and Swing components, such as
    `javax.swing.JButton`.
    
    Swing is a new GUI library developed to replace AWT, which suffered
    several drawbacks in bugs, resource consumption, and platform
    dependency.
    
    Rather than map components to those used by the platform, Swing
    draws the components directly.

4.  Determine whether the following statements are true or false:
    * You can add a button to a frame.
    * You can add a frame to a panel.
    * You can add a panel to a frame.
    * You can add any number of components to a panel or frame.
    * You can derive a class from a `JButton`, `JPanel`, or `JFrame`.
    
    True.
    
    False.
    
    True.
    
    True.
    
    True.

6.  Which of the following statements have syntax errors?
    
    .. code-block:: java
        
        Component c1 = new Component();
        JComponent c2 = new JComponent(); // Incorrect. JComponent is abstract.
        Component c3 = new JButton();
        JComponent c4 = new JButton();
        Container c5 = new JButton();
        c4.add(c4);
        Object c6 = new JButton();
        c5.add(c6);
    
    

8.  Describe `FlowLayout`. How do you create a `FlowLayout` manager?
    How do you add a component to a `FlowLayout` container? Is there a
    limit to the number of components that can be added to to a
    `FlowLayout` container?
    
    `FlowLayout` is a layout manager that arranges components in a row
    in the order they are added, wrapping automatically when the
    components fill the horizontal space.
    
    .. code-block:: java
        
        container.add(component);
    
    Limited only in how many components fit on the screen.

10. Describe `BorderLayout`. How do you create a `BorderLayout`
    manager? How do you add a component to a `BorderLayout` container?
    
    

12. What is the default layout manager for a `JPanel`? How do you add a
    component to a JPanel?

14. Since a GUI component class such as a JButton is a subclass of
    `Container`, can you add components into a button?
    
    

16. How do you create a font? How do you find all available fonts on
    your system?

18. Show the output of the following code:
    
    .. code-block:: java
        
        import javax.swing.*;
        
        public class Text {
            public static void main(String[] args) {
                JButton jbtOK= new JButton("OK");
                System.out.println(jbtOK.isVisible());
                JFrame frame = new JFrame();
                System.out.println(frame.isVisible());
            }
        }
    
    

20. What happens if you add a button to a container several times, as
    shown below? DOes it cause syntax errors? Does it cause runtime
    errors?
    
    .. code-block:: java
        
        JButton jbt = new JButton();
        JPanel panel = new JPanel();
        panel.add(jbt);
        panel.add(jbt);
        panel.add(jbt);
    
     Only the last one is shown. No and no.

22. Can a border or an icon be shared by GUI components?
    
    




