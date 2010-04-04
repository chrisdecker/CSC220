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
        
        Component c1 = new Component();   // Incorrect. Component is
                                          // abstract.
        JComponent c2 = new JComponent(); // Incorrect. JComponent is
                                          // also abstract.
        Component c3 = new JButton();     // Correct.
        JComponent c4 = new JButton();    // Correct.
        Container c5 = new JButton();     // Correct.
        c4.add(c4);                       // Correct.
        Object c6 = new JButton();        // Correct.
        c5.add(c6);                       // Incorrect.
                                          // Container.add(Object)
                                          // doesn't exist.

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
    
    `BorderLayout` layout manager lays out components into five areas
    (the borders and center of the container) according to a flag passed
    with the `Container.add()` method.
    
    .. code-block:: java
        
        import java.awt.BorderLayout;
        import javax.swing.*;
        
        JPanel container = new JPanel(new BorderLayout(5, 5));
        jButton compontent = new JButton("Center");
        container.add(component, BorderLayout.CENTER);

12. What is the default layout manager for a `JPanel`? How do you add a
    component to a JPanel?
    
    Default is `FlowLayout.
    
    .. code-block:: java
        
        import java.awt.FlowLayout;
        import javax.swing.*;
        
        JPanel container = new JPanel(new FlowLayout(5, 5));
        jButton compontent = new JButton("Close");
        container.add(component);

14. Since a GUI component class such as a JButton is a subclass of
    `Container`, can you add components into a button?
    
    Yes.

16. How do you create a font? How do you find all available fonts on
    your system?
    
    .. code-block:: java
        
        import java.awt.Font;
        import java.awt.GraphicsEnvironment;
        
        Font sans = new Font("SansSerif");
        
        GraphicsEnvironment env = GraphicsEnvironment.
            getlocalGraphicsEnvironment();
        
        String[] fontnames = env.getAvailableFontFamilyNames();

18. Show the output of the following code:
    
    .. code-block:: java
        
        import javax.swing.*;
        
        public class Test {
            public static void main(String[] args) {
                JButton jbtOK= new JButton("OK");
                System.out.println(jbtOK.isVisible());
                JFrame frame = new JFrame();
                System.out.println(frame.isVisible());
            }
        }
    
    ::
        
        true
        false

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
    
    Yes




