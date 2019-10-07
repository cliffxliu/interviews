/*
102. Binary Tree Level Order Traversal (Medium)
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        } 
        helper(root, 0, res);
        return res;
    }
    
    public void helper(TreeNode node, int level, List<List<Integer>> res) {
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(node.val);
        if (node.left != null) {
            helper(node.left, level + 1, res);
        }
        if (node.right != null) {
            helper(node.right, level + 1, res);
        }
    }
}

/*
Complexity:
Time: O(N). Each node is being processed once.
Space: O(N). Output List of Lists contains N node values.
*/
*/