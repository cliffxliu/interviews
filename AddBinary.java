/*
67. Add Binary (Easy)
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
*/

/* 
Cases:
1. Both numbers are 0 --> 0
2. One 1, One 0 --> 1
3. Both numbers are 1 --> Carry

Iterate through strings together, go through them, add values regardless.
Every iteration, formulate carry. 

Sum always starts as carry (from digit to its right).

sb.insert(0, sum % 2) will insert at beginning, instead of having to reverse at the end
*/

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        //Go right to left
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.insert(0, sum % 2);
            carry = sum / 2; //if 0, then 0; if 1, then 0; if 2, then 1
        }
        
        //After exiting the loop:
        if (carry > 0) {
            sb.insert(0, 1);
        }
        
        return sb.toString();
        
    }
}

/*
Complexity:
Time: O(N)
Space: O(N). StringBuilder copies contents of Strings a and b to another string.
*/

