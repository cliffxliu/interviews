/*
5. Longest Palindromic Substring (Medium)
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"
*/

class Solution {
    //DP Solution
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int left = 0;
        int right = 0;
        boolean[][] isPalindromeArray = new boolean[s.length()][s.length()];
        
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                boolean isInnerPalindrome = isPalindromeArray[i+1][j-1] || j - i <= 2;
                //When j - i == 2: characters at i and j have exactly 1 character between them (palindrome)
                //When j - i == 1: isInnerPalindrome = true since an empty string is a valid inner palindrome
 
                if (s.charAt(i) == s.charAt(j) && isInnerPalindrome) {
                    isPalindromeArray[i][j] = true;
                    if (j - i > right - left) {
                        right = j;
                        left = i;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}

/*
Complexity:
Time: O(n^2)
Space: O(n^2)
*/