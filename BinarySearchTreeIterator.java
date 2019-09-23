/**
173. Binary Search Tree Iterator (Medium)
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Example:
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
 

Note:
next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
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
class BSTIterator {
    
    //List of Nodes, added via in-order traversal
    List<Integer> sortedNodes;

    //
    int index;

    //In-Order traversal gives the elements in sorted order
    public BSTIterator(TreeNode root) {
        this.sortedNodes = new ArrayList<>();
        this.index = -1;
        this.inOrderTraversal(root);
    }
    
    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        this.inOrderTraversal(root.left);
        this.sortedNodes.add(root.val);
        this.inOrderTraversal(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        this.index++;
        return this.sortedNodes.get(this.index);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index < this.sortedNodes.size() - 1;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

/**
Complexity:
Time: O(N). Both next() and hasNext() take O(1) time. We do this for all the nodes.
Space: O(N). Used for the ArrayList to contain all the nodes.
*/