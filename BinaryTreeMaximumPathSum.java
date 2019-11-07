/*
124. Binary Tree Maximum Path Sum (Hard)
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:
Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:
Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int finalMax = Integer.MIN_VALUE; //Global variable for res
    
    public int maxPathSum(TreeNode root) {
        int tempMax = maxPathSumHelper(root);
        return finalMax;
    }
    
    //Calculates the max till current node (could be path, or could be current root's value)
    public int maxPathSumHelper(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int leftSum = maxPathSumHelper(root.left);
        int rightSum = maxPathSumHelper(root.right);

        // Compare leftSum + rool.val with rightSum + root.val to select which values to send further
        int maxTillNow = Math.max(leftSum + root.val, rightSum + root.val);
        
        // Check if the root value is greater than any of the path
        maxTillNow = Math.max(maxTillNow, root.val);
        
        //if root + left + root.val is greater than any of the max till now
        int tempMax = Math.max(maxTillNow, leftSum + rightSum + root.val);

        finalMax = Math.max(tempMax, finalMax);

        return maxTillNow;
    }
}