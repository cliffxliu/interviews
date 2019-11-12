/*
505. The Maze II (Medium)
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, 
left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at 
the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position 
(excluded) to the destination (included). If the ball cannot stop at the destination, return -1.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. 
You may assume that the borders of the maze are all walls. The start and destination coordinates 
are represented by row and column indexes.

 
Example 1:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: 12

Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
             The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.


Example 2:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: -1

Explanation: There is no way for the ball to stop at the destination.

Note:
There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
*/

class Solution {
    //Same as The Maze BFS, but use 3-element arrays: {x, y, length}
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int res = Integer.MAX_VALUE;
        //Edge Case
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return 0;
        }
        
        //Instantiate Queue for BFS
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {start[0], start[1], 0}); //{x, y, length}
        
        //Instantiate length array
        int[][] length = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                length[i][j] = Integer.MAX_VALUE;
            }
        }
        
        
        //Directions we can take
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (length[curr[0]][curr[1]] <= curr[2]) {
                continue;
            }
            length[curr[0]][curr[1]] = curr[2];
            
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                res = Math.min(res, curr[2]);
            }
            
            
            for (int[] dir: dirs) {
                int x = curr[0];
                int y = curr[1];
                int d = curr[2];
                //Go to next stop (after rolling)
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    d++;
                }
                //Now, x and y are out of bounds
                //Go back to previous cell that is valid
                x -= dir[0];
                y -= dir[1];
                d--;
                
                //Add new start point with distance
                queue.add(new int[] {x, y, d});
            }
        }
        //Return: res or -1
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }
}