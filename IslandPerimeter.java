/*
463. Island Perimeter (Easy)
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:
Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16
*/

class Solution {
    /*
    1. loop over the matrix and count the number of islands
    2. if the current dot is an island, count if it has any right neighbour or down            neighbour, we only need to check right & down because we start at the upper left
    3. the result is islands * 4 - neighbours * 2 because every neighbor covers two            units of perimeter, which subtracts from the 4 sides of each island
    */
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numIslands = 0;
        int numNeighbors = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numIslands++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        numNeighbors++;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        numNeighbors++;
                    }
                }
            }
        }
        return numIslands * 4 - numNeighbors * 2;
    }
}

/*
Complexity:
Time: O(numRows * numCols). We visit each cell in the matrix once.
Space: O(1). Constant space since we're not storing anything.
*/