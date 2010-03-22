/*
Author:       Erik Youngren <eyoungre@callutheran.edu>
Date Created: 2010-03-02

Purpose
=======
Solution to Programming Exercise 6.28:

    Game: TicTacToe
    
    Write a program that randomly fills 0s and 1s into a TicTacToe
    board, prints the board, and finds the rows, columns, or diagonals
    with all 0s or 1s. Use a two dimensional array to represent a
    TicTacToe boeard. Here is a sample run of the program:
    
    ::
        
        001
        001
        111
        All 1's on row 2
        All 1s on column 2

*/

/**
 * Driver class
 */
class main {
    public static void main (String[] args) {
        int[][] tictactoe = new int[3][3];
        
        System.out.print("\n");
        
        // populate the board
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                tictactoe[i][j] = (int)Math.round(Math.random());
                System.out.printf("%d ", tictactoe[i][j]);
            }
            System.out.printf("\n");
        }
        
        // check rows
        for(int i = 0; i < 3; i++) {
            if(tictactoe[i][0] == tictactoe[i][1] &&
               tictactoe[i][1] == tictactoe[i][2])
            {
                System.out.printf("All %d's on row %d\n",
                    tictactoe[i][0], i);
            }
        }
        
        // check columns
        for(int j = 0; j < 3; j++) {
            if(tictactoe[0][j] == tictactoe[1][j] &&
               tictactoe[1][j] == tictactoe[2][j])
            {
                System.out.printf("All %d's on column %d\n",
                    tictactoe[0][j], j);
            }
        }
        
        // check diagonals
        if(tictactoe[0][0] == tictactoe[1][1] &&
           tictactoe[1][1] == tictactoe[2][2])
        {
            System.out.printf("All %d's on back diagonal\n",
                tictactoe[0][0]);
        }
        
        if(tictactoe[0][2] == tictactoe[1][1] &&
           tictactoe[1][1] == tictactoe[2][0])
        {
            System.out.printf("All %d's on forward diagonal\n",
                tictactoe[0][2]);
        }
    }
}

