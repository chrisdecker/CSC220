/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-00-00

16.8 - Displaying the mouse position
====================================
Write two programs, such that one displays the mouse position when the
mouse is clicked (See Figure (7e 15.20(b))) and the other displays the
mouse position when the mouse is pressed and ceases to display it when
the mouse is released.

*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Driver class
 */
public class MouseCoordinates {
    public static void main (String[] args) {
        CoordsOnClick click = new CoordsOnClick();
        CoordsDuringPress press = new CoordsDuringPress();
        click.setVisible(true);
        press.setVisible(true);
    }
}

class CoordsOnClick extends JFrame {
    private JPanel canvas;
    private MousePosition position;
    
    public CoordsOnClick() {
        this.setTitle("Mouse Coordinates - On Click");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5,5));
        this.setSize(300,200);
        this.setLocation(0,0);
        
        this.canvas = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString(position.toString(),
                    position.x, position.y);
            }
        };
        
        this.canvas.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {
                position = new MousePosition(e.getPoint());
                canvas.repaint();
            }
            
            public void mouseReleased(MouseEvent e) {
            }
            
            public void mouseClicked(MouseEvent e) {
            }
            
            public void mouseEntered(MouseEvent e) {
            }
            
            public void mouseExited(MouseEvent e) {
            }
        });
        
        this.add(this.canvas, BorderLayout.CENTER);
    }
}

class CoordsDuringPress extends JFrame {
    private JPanel canvas;
    private MousePosition position;
    private boolean display = false;
    
    public CoordsDuringPress() {
        this.setTitle("Mouse Coordinates - During Button Press");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5,5));
        this.setSize(300,200);
        this.setLocation(300,0);
        
        this.canvas = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if(display) {
                    g.drawString(position.toString(),
                        position.x, position.y);
                }
            }
        };
        
        this.canvas.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {
                display = true;
            }
            
            public void mouseReleased(MouseEvent e) {
                display = false;
                canvas.repaint();
            }
            
            public void mouseClicked(MouseEvent e) {
            }
            
            public void mouseEntered(MouseEvent e) {
            }
            
            public void mouseExited(MouseEvent e) {
            }
        });
            
        this.canvas.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                position = new MousePosition(e.getPoint());
                canvas.repaint();
            }
            
            public void mouseMoved(MouseEvent e) {
            }
        });
        
        this.add(this.canvas, BorderLayout.CENTER);
    }
}

class MousePosition {
    public int x;
    public int y;
    
    public MousePosition(double x, double y) {
        this.x = (int)x;
        this.y = (int)y;
    }
    
    public MousePosition(Point p) {
        this(p.getX(), p.getY());
    }
    
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }
}
