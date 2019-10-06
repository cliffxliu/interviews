/* 344. Reverse String (Easy)
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.
Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/


class Solution {
    public void reverseStringIterative(char[] s) {
        int i = 0;
        int j = s.length - 1;
        
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public String reverseStringRecursive(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
}

/*
Complexity:
Iterative:
Time: O(N). Needs to reverse the whole string.
Space: O(N). Transform String to character array.

Recursive:
Time: O(NlogN). Concatentation function: If it is O(N), then T(n) = 2T(n/2) + O(n) => T(n) = O(n log(n))
Space: O(h). Where h is depth of recursion tree = logN.
*/