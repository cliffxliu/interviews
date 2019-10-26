/*
17. Letter Combinations of a Phone Number (Medium)
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinationsRecursive(res, digits, "", 0, mapping);
        return res;
    }
    
    public void letterCombinationsRecursive(List<String> res, String digits, String curr, int index, String[] mapping) {
        if (index == digits.length()) {
            res.add(curr);
            return;
        } 
        
        String letters = mapping[digits.charAt(index) - '0']; //Converts to int
        for (int i = 0; i < letters.length(); i++) { //Iterate through all characters per key
            letterCombinationsRecursive(res, digits, curr + letters.charAt(i), index + 1, mapping);
        }
    }
}