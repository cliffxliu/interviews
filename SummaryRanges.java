/* 
228. Summary Ranges (Medium)
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:
Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.

Example 2:
Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i]; //new curr each for loop
            //As long as our left-most index is not out of bounds
            //And we have consecutive numbers
            while ((i < nums.length - 1) && (nums[i + 1] == nums[i] + 1)) {
                i++;
            }
            //Once we don't have consecutive numbers
            if (curr != nums[i]) {
                res.add(curr + "->" + nums[i]);
            //We didn't iterate i (either we're out of bounds or not consecutive) curr == nums[i]
            } else {
                res.add(curr + "");
            }
        }
        return res;
    }
}

/*
Complexity:
Time: O(N)
Space: O(1) if we don't count return list