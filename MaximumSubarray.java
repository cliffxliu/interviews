/*
53. Maximum Subarray (Easy)
Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int localRes = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            localRes = Math.max(nums[i], localRes + nums[i]);
            res = Math.max(res, localRes);
        }
        
        return res;
    }
}

/*
Complexity:
Time: O(N), since it's one pass along the array
Space: O(1), since it's a constant space solution.
*/