/*
290. Word Pattern (Easy)
Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:
Input: pattern = "abba", str = "dog cat cat dog"
Output: true

Example 2:
Input:pattern = "abba", str = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false

Example 4:
Input: pattern = "abba", str = "dog dog dog dog"
Output: false

Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
*/

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] individualStr = str.split(" ");
        if (individualStr.length != pattern.length()) {
            return false;
        }
        Map mapPatternToIndex = new HashMap();
        //Use Integer because it contains a pointer that can be used to reference an object (unique bijection)
        for (Integer i = 0; i < pattern.length(); i++) {
            //put returns previous value or null
            if (mapPatternToIndex.put(pattern.charAt(i), i) != mapPatternToIndex.put(individualStr[i], i)) {
                return false;
            }
        }
        return true;
    }
}

/* 
Complexity:
Time: O(N)
Space: O(N)
*/