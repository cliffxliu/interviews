/*
49. Group Anagrams (Medium)
Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:
All inputs will be in lowercase.
The order of your output does not matter.
*/

class Solution {
    /* HashMap: String --> List where each Key (String) is sorted and each Value (List) is a list of strings when sorted is equal to the Key */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> res = new HashMap<String, List>();
        for (String s: strs) {
            /* sort each string */
            char[] currString = s.toCharArray();
            Arrays.sort(currString);
            String sortedKey = new String(currString);
            if (!res.keySet().contains(sortedKey)) {
                res.put(sortedKey, new ArrayList());
                //Ensures that we have sortedKey as a Key, so we can add to its list
            }
            res.get(sortedKey).add(s); //Otherwise, add it to the already existing key
        }
        System.out.println(res);
        return new ArrayList(res.values());
    }
}

/*
Complexity:
Time: O(N * KlogK). N = strs.length. K = max length of a string in strs. N * number of sorts.
Space: O(N * K). Total information stored in res.
*/