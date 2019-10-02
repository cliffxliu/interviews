/*
257. Binary Tree Paths (Easy)
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:
Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, "", res);
        return res;
        
    }
    
    public void dfs(TreeNode root, String path, List<String> paths) {
        path += root.val;
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        if (root.left != null) {
            dfs(root.left, path + "->", paths);
        }
        if (root.right != null) {
            dfs(root.right, path + "->", paths);
        }
    }
}

/*
Complexity:
Time: O(N). Where N is the number of nodes.
Space: O(N). Where N is the number of nodes, since paths contains as many elements as leafs in the trees
and couldn't b e larger than log N for the trees containing more than one element. Best case would be 
O(logN) for a balanced tree.
*/