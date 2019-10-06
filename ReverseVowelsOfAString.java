/*
345. Reverse Vowels of a String (Easy)
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"

Example 2:
Input: "leetcode"
Output: "leotcede"

Note:
The vowels does not include the letter "y".
*/

class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet();
        set.add('A');
        set.add('a');
        set.add('E');
        set.add('e');
        set.add('I');
        set.add('i');
        set.add('O');
        set.add('o');
        set.add('U');
        set.add('u');
        
        int left = 0;
        int right = s.length() - 1;
        char[] res = s.toCharArray();
        
        while (left < right) {
            while (left < right && !set.contains(res[left])) {
                left++;
            }
            while (left < right && !set.contains(res[right])) {
                right--;
            }
            char temp = res[left];
            res[left] = res[right];
            res[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(res);
        
    }
}

/*
Complexity:
Time: O(N). One pass through the string.
Space: O(1). Constant in-place modification.
*/
