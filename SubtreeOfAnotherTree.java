/*
572. Subtree of Another Tree (Easy)
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.

Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
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
    //Break down s until it's null to find a subtree == t
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (helper(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null) { //Base case
            return true;
        }
        if (s == null || t == null) { 
            //If either gets reduced down to null, then return false
            return false;
        }
        if (s.val != t.val) {
            //Check if value at subtree matches
            return false;
        }
        //Subtrees must match structure exactly
        return helper(s.left, t.left) && helper(s.right, t.right); 
    }
}