/*
240. Search a 2D Matrix II (Medium)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}

/*
Complexity:
Time: O(n + m). Linear in the sum of the dimensions of the matrix because
row can only be decremented n times and col can only be decremented m times.

Space: O(1).
*/