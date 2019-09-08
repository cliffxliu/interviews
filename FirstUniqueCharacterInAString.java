/*
387. First Unique Character in a String (Easy)
Given a string, find the first non-repeating character in it and return it's index. 
If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

*/

class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        
        /* Maps each character to index */
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!map.containsKey(curr)) {
                map.put(curr, i);
            } else {
                map.put(curr, -1);
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (char c: map.keySet()) {
            if (map.get(c) != -1) {
                res = Math.min(res, map.get(c));
            }
        }
        
        if (res < Integer.MAX_VALUE) {
            return res;
        }
        return -1;
    }
}

/*
Complexity:
Time: O(N). Iterate through s.length() once
Space: O(1). Maximum of size 26 (constant)
*/