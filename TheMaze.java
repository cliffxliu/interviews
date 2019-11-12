/*
490. The Maze (Medium)
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

 

Example 1:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true

Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false

Explanation: There is no way for the ball to stop at the destination.
*/

class Solution {
    //BFS
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //Edge Case
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        //Instantiate Queue for BFS
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(start);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true;
        
        //Directions we can take
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < dir.length; i++) {
                int x = curr[0];
                int y = curr[1];
                //Go to next stop (after rolling)
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[i][0];
                    y += dir[i][1];
                }
                //Now, x and y are out of bounds
                //Go back to previous cell that is valid
                x -= dir[i][0];
                y -= dir[i][1];
                //RESET: If the previous cell is visited, then we break out and go to next iteration of the loop 
                if (visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                if (x == destination[0] && y == destination[1]) {
                    return true;
                }
                queue.add(new int[] {x, y});
            }
        }
        return false;
    }
}