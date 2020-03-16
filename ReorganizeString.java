/*
767. Reorganize String (Medium)
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].
*/

class Solution {
    /* Greedy: need Map and DS that tells us what is most frequent character --> organized (Max Heap) */
    public String reorganizeString(String S) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c: S.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a)); 
        maxHeap.addAll(counts.keySet());
        
        StringBuilder res = new StringBuilder(); //Strings are expensive
        //Loop through maxHeap, take 2 elements at a time. Unique keys of Map will prevent consecutive 
        //characters that are the same.
        while (maxHeap.size() > 1) { //Greedily taking most frequent characters
            char curr = maxHeap.remove();
            char next = maxHeap.remove();
            //Greedy:
            res.append(curr);
            res.append(next);
            counts.put(curr, counts.get(curr) - 1);
            counts.put(next, counts.get(next) - 1);
            if (counts.get(curr) > 0) {
                maxHeap.add(curr);
            }
            if (counts.get(next) > 0) {
                maxHeap.add(next);
            }
        }
        
        //Edge Case:
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.remove();
            if (counts.get(last) > 1) {
                return "";
            } else {
                res.append(last);
            }
        }

        return res.toString();
        
    }
}