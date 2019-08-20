/* 79. Word Search (Medium)
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

class Solution {
    /**
    Look through grid at every cell.
    If we find 1st letter of word, start a DFS(board, row i, column j, countLettersWeFound, word) from that cell.
    */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false; 
    }
    
    /**
    @param board the board (doesn't change)
    @param i the current row we are on
    @param j the current column we are on
    @param count the number of letters we've currently found
    @param word (doesn't change since we're using charAt)
    Base Case: if count == word.length() --> return true;
    Base Case 2: out of bounds or board[i][j] does NOT contain word.charAt(count) --> return false
    Recursive Case: Haven't found remainder of word, still in grid, character we're looking for, we just found. Continue recursion:
        We know same cell cannot be used more than once. Mark current cell as an empty space. 
        From remainder, can we find the rest of the word? 
            --> boolean found = dfs(board, UP) or dfs(board, DOWN), or dfs(board, LEFT), or dfs(board, RIGHT)
    */
    public boolean dfs(char[][] board, int i, int j, int count, String word) {
        if (count == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != word.charAt(count)) {
            return false;
        } 
        
        /* at this point, we found character we're looking for, so continue recursion: */
        char currentCellNoRepeat = board[i][j];
        board[i][j] = ' ';
        boolean foundAlready = dfs(board, i - 1, j, count + 1, word) || dfs(board, i + 1, j, count + 1, word) 
            || dfs(board, i, j - 1, count + 1, word) || dfs(board, i, j + 1, count + 1, word);
        board[i][j] = currentCellNoRepeat; //shuffle this back (now available to be used again);
        return foundAlready;
    }
}

/*
Complexity:
Time: O(N^2)
Space: O(N^2)
*/