/* 
560. Subarray Sum Equals K (Medium)
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/

/**
The simplest way to do this is to use O(N^2) time but O(N) space, start for (int i = 0) and then for (int j = i), 
if sum == k, count++
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int partialSum = 0;
        Map<Integer, Integer> map = new HashMap<>(); //Key: partialSum, Value: Number of ways
        map.put(0, 1); 
        for (int i = 0; i < nums.length; i++) {
            partialSum += nums[i];
            if (map.containsKey(partialSum - k)) { //If 
                res += map.get(partialSum - k);
            }
            if (map.containsKey(partialSum)) {
                map.put(partialSum, map.get(partialSum) + 1); //partialSum --> number of occurrences
            } else {
                map.put(partialSum, 1);
            }
        }
        return res;
    }
}

/*
Complexity:
Time: O(N)
Space: O(N)
*/