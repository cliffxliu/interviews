/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
*/
class Solution {
    public ListNode reverseListIteratively(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next; // save next
            curr.next = prev; //reverse 1
            prev = curr; //reverse 2
            curr = next; //advance prev and current
        }
        return prev;
    }

    public ListNode reverseListRecursively(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next; // save next
            curr.next = prev; //reverse 1
            prev = curr; //reverse 2
            curr = next; //advance prev and current
        }
        return prev;
    }
}

/* 
Complexity Analysis:

Iterative:
Time: O(n)
Space: O(1)

Recursive:
Time: O(n). Assume that n is the list's length, the time complexity is O(n).
Space: O(n). The extra space comes from implicit stack space due to recursion.
The recursion could go up to n levels deep.
*/


