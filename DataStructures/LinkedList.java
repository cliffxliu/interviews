/** Linked Lists */
class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}

public class DLL { 
    Node head; // head of list 
  
    /* Doubly Linked list Node*/
    class Node { 
        int data; 
        Node prev; 
        Node next; 
  
        // Constructor to create a new node 
        // next and prev is by default initialized as null 
        Node(int d) { data = d; } 
    } 

    public void push(int new_data) { 
        /* 1. allocate node  
        * 2. put in the data */
        Node new_Node = new Node(new_data); 
      
        /* 3. Make next of new node as head and previous as NULL */
        new_Node.next = head; 
        new_Node.prev = null; 
      
        /* 4. change prev of head node to new node */
        if (head != null) 
            head.prev = new_Node; 
      
        /* 5. move the head to point to the new node */
        head = new_Node; 
    } 
} 

/** 
1) A DLL can be traversed in both forward and backward direction.
2) The delete operation in DLL is more efficient if pointer to the node to be deleted is given.
3) We can quickly insert a new node before a given node.
In singly linked list, to delete a node, pointer to the previous node is needed. 
To get this previous node, sometimes the list is traversed. 
In DLL, we can get the previous node using previous pointer.
*/