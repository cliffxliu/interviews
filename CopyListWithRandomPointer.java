/*
138. Copy List with Random Pointer (Medium)

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/


//Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        /* Clone map that maps original node to its clone. */
        Map<Node, Node> map = new HashMap<>();
        
        /* 1st pass: copy each node so that all nodes have their clone in the mapping */
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        /* 2nd pass: Give all clones their next and random pointer assignments. 
           Clone map allows us to reach original node in O(1) time. */
        curr = head; //Reset curr pointer
        while (curr != null) {
            map.get(curr).next = map.get(curr.next); //set (next of curr's clone) to (clone of curr's next)
            map.get(curr).random = map.get(curr.random); //set (random of curr's clone) to (clone of curr's random)
            curr = curr.next;
        }
        
        return map.get(head); //Caller's access to newly copied list
        
    }
}

/*
Complexity:
Time: O(N)
Space: O(N). Original node is mapped to cloned node.
*/