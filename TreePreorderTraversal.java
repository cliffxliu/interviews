/*
589. Tree Preorder Traversal (Easy)
Given an n-ary tree, return the preorder traversal of its nodes' values.
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        for (Node c: root.children) {
            preorder(c);
        }
        return res;
    }
}

/*
Complexity:
Time: O(N). Recursive function is T(N) + 2 * T(N / 2) + 1.
Space: O(N).
*/