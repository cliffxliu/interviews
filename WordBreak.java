/*
139. Word Break (Medium)
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/

class Solution {
    /* 
    Use DP: s can be divided into subproblems s1 and s2. 
    If s1 and s2 satisfy the required conditions, s does as well. 
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=  new HashSet(wordDict);
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; //Null string is always present in the dictionary, rest are false
        
        /*
        Use two pointers: 
        i represents substring length considered from beginning
        j represents index partitioning into (0, j) and (j + 1, i)
        */
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) { //If s1 fulfills criteria AND s2 is present
                    dp[i] = true; //Then dp[i] must be true
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}