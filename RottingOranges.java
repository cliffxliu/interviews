/*
994. Rotting Oranges (Easy)
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Example 1:
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        
        //Find all rotten orange coordinates
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; //directions that rot
        
        int res = -1; 
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll(); //current Rotten
                for (int[] dir: dirs) {
                    //If adjacent to an orange in any of the 4 directions
                    int newX = curr[0] + dir[0]; 
                    int newY = curr[1] + dir[1];
                    
                    if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || grid[newX][newY] != 1) { //Simulate rotting
                        continue;
                    }
                    
                    grid[newX][newY] = 2;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        if (res == -1) { //res didn't change
            return 0;
        } else {
            return res;
        }
        
    }
}