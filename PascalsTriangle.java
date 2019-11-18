/*
118. Pascal's Triangle (Easy)
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (numRows == 0) {
            return res;
        }
        
        res.add(new ArrayList<>());
        res.get(0).add(1);
        
        for (int row = 1; row < numRows; row++) {
            List<Integer> curr = new ArrayList<>();
            List<Integer> prev = res.get(row - 1);
            
            curr.add(1);
            for (int j = 1; j < row; j++) { //middle elements
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);
            
            res.add(curr);
        }
        
        return res;
        
    }
}