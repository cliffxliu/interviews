/*
160. Intersection of Two Linked Lists (Easy)
Write a program to find the node at which the intersection of two singly linked lists begins.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Advance longer list until they are the same size
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        //If A is longer
        while (sizeA > sizeB) {
            headA = headA.next;
            sizeA--;
        }
        //If B is longer
        while (sizeB > sizeA) {
            headB = headB.next;
            sizeB--;
        }
        
        //Search for intersection
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA; //null if they don't intersect (expected behavior)
        
    }
    
    public int getSize(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
}