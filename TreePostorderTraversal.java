/*
590. N-ary Tree Postorder Traversal (Easy)
Given an n-ary tree, return the postorder traversal of its nodes' values.
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
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return res;
        }
        for (Node c: root.children) {
            postorder(c);
        }
        res.add(root.val);
        return res;
    }
}

/*
Complexity:
Time: O(N). Recursive function is T(N) + 2 * T(N / 2) + 1.
Space: O(N).
*/