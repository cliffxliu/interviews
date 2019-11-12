/*
938. Range Sum of BST (Easy)
Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

Example 1:
Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32

Example 2:
Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23
 
Note:
The number of nodes in the tree is at most 10000.
The final answer is guaranteed to be less than 2^31.
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
    /* Traverse the entire tree by doing a BFS, at each iteration of the BFS:
    add the current node's value to your running sum if its value is between L and R (inclusive). 
    Then check if the current node has a left child and if its value could be within the range of L, 
        if it could be: add the left child to the queue to be processed. 
    Then check if the current node has a right child and if its value could be within the range of R, 
        if it could be: add the right child to the queue to be processed. 
    Once your BFS is finished, return your sum. 
    */
    public int rangeSumBST(TreeNode root, int L, int R) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.val >= L && curr.val <= R) {
                res += curr.val;
            }
            //If there exists a value to the left of us that's still greater than L (valid). Don't need equals since BST.
            if (curr.left != null && curr.val >= L) { 
                queue.add(curr.left);
            }
            //If there exists a value to the right of us that's still less than R (valid).
            if (curr.right != null && curr.val <= R) {
                queue.add(curr.right);
            }
        }
        return res;
    }
}