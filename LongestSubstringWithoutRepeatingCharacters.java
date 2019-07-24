/* 
3. Longest Substring Without Repeating Characters (Medium)
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        
        while (l < s.length() && r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;   
            }
            else {
                set.remove(s.charAt(l));
                l++;
            }
            res = Math.max(res, r - l);
        }
        
        return res;
        
    }
}

/*
Complexity:
Time: O(N)
Space: O(min(26, N))