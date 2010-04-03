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
import javax.swing.JButton;

/**
 * Driver class
 */
public class main {
    public static void main (String[] args) {
        TicTacToe game = new TicTacToe();
        
        game.setVisible(true);
    }
}

class TicTacToe extends JFrame {
    public TicTacToe() {
        this.setTitle("Tic Tac Toe");
        this.setLayout(new GridLayout(0, 3, 5, 5));
        this.setSize(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
}
