/*
103. Binary Tree Zigzag Level Order Traversal (Medium)
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        //BFS: At any given node, we're either going from L->R or R->L, so we keep track of reverse boolean
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> tempList = new LinkedList<>(); //We will add this to res
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (reverse) { //Right to left
                    tempList.addFirst(curr.val);
                } else { //Left to right
                    tempList.add(curr.val); 
                }
                
                //Process children nodes
                if (curr.left != null) {
                    queue.add(curr.left); 
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(tempList);
            reverse = !reverse;
        }
        
        return res;
    }
}