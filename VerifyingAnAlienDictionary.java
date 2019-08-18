/*
953. Verifying an Alien Dictionary (Easy)
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 
Note:
1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are english lowercase letters.
*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        
        /* Populate index with new ordering */
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(index, words[i], words[i+1]) <= 0) { //'card' vs. 'car'
                return false;
            }
        }
        return true;
    }
    
    public int compare(int[] indices, String s1, String s2) {
        int maxLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < maxLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return indices[s2.charAt(i) - 'a'] - indices[s1.charAt(i) - 'a'];
            }
        }
        return 0;
    }
}

/*
Complexity:
Time: O(N), total content of words
Space: O(1). Constant (size 26).
*/