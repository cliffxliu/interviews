/*
41. First Missing Positive (Hard)
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:
Input: [1,2,0]
Output: 3

Example 2:
Input: [3,4,-1,1]
Output: 2

Example 3:
Input: [7,8,9,11,12]
Output: 1

Note:
Your algorithm should run in O(n) time and uses constant extra space.
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        //First check if 1 is contained
        boolean containsOne = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                containsOne = true;
                break;
            }
        }
        
        if (!containsOne) { return 1; } 
        
        //If 1 is contained but is the only value in nums
        if (nums.length == 1) { return 2; }
        
        //Replace negatives, zeros, and numbers greater than n with 1s
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] <= 0) || (nums[i] > nums.length)) {
                nums[i] = 1;
            }
        }
        
        //Index into array
        //If nums[i] is negative, then i is present in the array
        //If nums[i] is positive, then i is missing
        for (int i = 0; i < nums.length; i++) {
            //If we meet a, change the sign of the ath element if it's positive only
            int a = Math.abs(nums[i]) % nums.length;
            if (nums[a] > 0) {
                nums[a] *= -1;
            }
            
        }
        
        //Search for first missing positive
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        
        
        if(nums[0] > 0) {
            return nums.length;
        }
    
        
        return nums.length + 1;
    }
}