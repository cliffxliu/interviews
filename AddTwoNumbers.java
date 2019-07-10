/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        
        ListNode p = l1;
        ListNode q = l2;
        
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        
        while (p != null || q != null) {
            int x, y;
            if (p != null) {
                x = p.val;
            }
            else {
                x = 0;
            }
            
            if (q != null) {
                y = q.val;
            }
            else {
                y = 0;
            }
            
            int sum = x + y + carry;
            carry = sum / 10; //if carry < 0, then it's just 0
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
/*
Complexity Analysis:
Time: O(max(m.size(), n.size()))
Space: O(max(m.size(), n.size()) + 1)
*/