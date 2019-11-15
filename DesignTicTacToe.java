/*
348. Design Tic-Tac-Toe (Medium)
Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Example:
Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
Follow up:
Could you do better than O(n2) per move() operation?
*/

class TicTacToe {

    int[][] grid;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        grid = new int[n][n];
        
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (row >= grid.length || col >= grid[0].length) {
            return 0;
        }
        
        if (grid[row][col] != 0) {
            return 0;
        }
        
        if (player == 1) {
            grid[row][col] = 1;
        } else {
            grid[row][col] = 2;
        }
        
        if (verticalWin(col, player)) {
            return player;
        }
        
        if (horizontalWin(row, player)) {
            return player;
        }
        
        if (diagonalWin(row, col, player)) {
            return player;
        }

        return 0;    
    }
    
    public boolean verticalWin(int col, int player) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] != player) {
                return false;
            }
        }
        return true;
    }
    
    public boolean horizontalWin(int row, int player) {
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[row][i] != player) {
                return false;
            }
        }
        return true;
    }
    
    public boolean diagonalWin(int row, int col, int player) {
        if (row != col && row + col != grid.length - 1) { //Must go through center
            return false;
        }
        boolean topLeftToBottomRight = true;
        boolean topRightToBottomLeft = true;
        
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][i] != player) {
                topLeftToBottomRight = false;
            }
        }
        for (int i  =0; i < grid.length; i++) {
            if (grid[i][grid.length - 1 - i] != player) {
                topRightToBottomLeft = false;
            }
        }
        return topRightToBottomLeft || topLeftToBottomRight;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */