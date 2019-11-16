/*
140. Word Break II (Hard)
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:
Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:
Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
*/

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> wordDictSet = new HashSet(wordDict);
        
        //Keep a hash set of indices that you cannot break up from that index to end of string. Use with foundWord boolean.
        Set<Integer> badIndices = new HashSet<>(); 
        
        dfs(badIndices, 0, res, s, "", wordDictSet);
        return res;
    }
    
    /*
    Recursive DFS function: L->R
    At each point, iterate from currIndex to end of the string to see if you can form words along the way.
    If a word is found, update the current index to the position right after the word, and call the recursive function.
    */
    public boolean dfs(Set badIndices, int index, List<String> res, String s, String currSentence, Set<String> wordDict) {
        boolean foundWord = false;
        
        for (int i = index; i < s.length(); i++) {
            if (wordDict.contains(s.substring(index, i + 1))) {
                String newSentence = currSentence + " " + s.substring(index, i + 1);
                if (i == s.length() - 1) {
                    res.add(newSentence.substring(1)); //1 == beginIndex
                    foundWord = true;
                } else {
                    if (badIndices.contains(i + 1)) {
                        continue;
                    }
                    if (dfs(badIndices, i + 1, res, s, newSentence, wordDict)) {
                        foundWord = true;
                    }
                }
            }
        }
        
        if (foundWord) {
            return true;
        } else {
            badIndices.add(index);
            return false;
        }
    }
}