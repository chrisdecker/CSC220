/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-00-00

Purpose
=======
To solve the Programming Exercise 12.7 (7e 13.7)

    Game: Displaying a TicTacToe board
    ----------------------------------
    Display a frame that contains nine labels. A label may display an
    image icon for X, an image icon for O, or nothing, as shown in
    figure (7e 13.16(c)). What to display is randomly decided. Use the
    `Math.random()` method to generate an integer `0`, `1`, or `2`,
    which corresponds to displaying a cross image icon, a not image
    icon, or nothing. The cross and not images are in the files `x.gif`
    and `o.gif`, which are under the `image` directory in
    http://www.cs.armstrong.edu/liang/intro7e/evennumberedexercise.zip

*/

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * Driver class
 */
public class main {
    public static void main (String[] args) {
        TicTacToe game = new TicTacToe();
        
        game.setVisible(true);
    }
}
/**
 * TicTacToe window.
 * 
 */
class TicTacToe extends JFrame {
    /**
     * Width of the game
     * 
     */
    public final int GAME_WIDTH = 3;
    
    /**
     * Height of the game
     * 
     */
    public final int GAME_HEIGHT = 3;
    
    /**
     * List of game icons (x's, o's and empty.)
     * 
     */
    private ImageIcon[] icons = new ImageIcon[3];
    
    /**
     * Labels used in game to display game icons.
     * 
     */
    private JLabel[][] labels = new JLabel[GAME_WIDTH][GAME_HEIGHT];
    
    /**
     * Construct TicTacToe window.
     * 
     */
    public TicTacToe() {
        // Initialize the window itself.
        this.setTitle("Tic Tac Toe");
        this.setLayout(new GridLayout(0, this.GAME_WIDTH, 5, 5));
        this.setSize(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Initialize the game icons.
        this.icons[0] = new ImageIcon("images/cross.gif");
        this.icons[1] = new ImageIcon("images/not.gif");
        this.icons[2] = new ImageIcon();
        
        // Create the labels, assign an image at random and populate
        // the window.
        for(int i = 0; i < this.GAME_WIDTH; i++) {
            for (int j = 0; j < this.GAME_HEIGHT; j++) {
                int image = (int)(Math.round(Math.random() * 2));
                JLabel square = new JLabel(this.icons[image]);
                this.add(square);
                this.labels[i][j] = square;
            }
        }
    }
}

