/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-00-00

16.3 - Moving the Ball
======================
Write a program that moves the ball in the panel. You should define a
panel class for displaying the ball and provide the methods for moving
the button left, right, up, and down, as shown in Figure (7e 15.20(a)).

*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class ButtonBall extends JFrame {
    private Circle ball;
    private JPanel canvas;
    
    public ButtonBall() {
        this.setSize(300,200);
        this.setTitle("Button Ball");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5,5));
        
        this.ball = new Circle(100,100);
        
        this.canvas = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                ball.draw(g);
            }
        };
        
        this.add(BorderLayout.CENTER, canvas);
        
        this.add(BorderLayout.SOUTH, new JPanel() {{
            setLayout(new GridLayout(0, 4, 5, 5));
            
            add(new JButton("Left") {{
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ball.translate(-10,0);
                        canvas.repaint();
                    }
                });
            }});
            
            add(new JButton("Right") {{
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ball.translate(10,0);
                        canvas.repaint();
                    }
                });
            }});
            
            add(new JButton("Up") {{
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ball.translate(0,-10);
                        canvas.repaint();
                    }
                });
            }});
            
            add(new JButton("Down") {{
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ball.translate(0,10);
                        canvas.repaint();
                    }
                });
            }});
        }});
    }
    
    public static void main (String[] args) {
        ButtonBall frame = new ButtonBall();
        frame.setVisible(true);
    }
}

class Circle {
    private int radius;
    private int x;
    private int y;
    
    public Circle() {
        this(10);
    }
    
    public Circle(int radius) {
        this(radius, 0, 0);
    }
    
    public Circle(int x, int y) {
        this(10, x, y);
    }
    
    public Circle(int radius, int x, int y) {
        this.size(radius);
        this.position(x, y);
    }
    
    public void position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void translate(int x, int y) {
        this.position(this.x + x, this.y + y);
    }
    
    public void size(int size) {
        this.radius = size;
    }
    
    public void scale(double factor) {
        this.size((int)(this.radius * factor));
    }
    
    public void draw(Graphics g) {
        g.drawOval(this.x, this.y, this.radius, this.radius);
    }
}

