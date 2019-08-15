/*
238. Product of Array Except Self (Medium)
Given an array nums of n integers where n > 1,  
return an array output such that output[i] is equal 
to the product of all the elements of nums except nums[i].

Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]

Note: Please solve it without division and in O(n).
Follow up:
Could you solve it with constant space complexity? 
(The output array does not count as extra space 
for the purpose of space complexity analysis.)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        /* L[i] will contain product of all nums to left of L[i] */
        int[] L = new int[nums.length];
        
        /* R[i] will contain product of all nums to right of L[i] */
        int[] R = new int[nums.length];
        
        int[] res = new int[nums.length];
        
        L[0] = 1; //no elements to left, so 1
        for (int i = 1; i < nums.length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        
        R[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        
        for (int i = 0; i < nums.length; i++) {
            res[i] = L[i] * R[i];
        }
        
        return res;
    }
}


/*
Complexity: 
Time: O(N)
Space: O(N). Used by 2 L and R arrays.
https://leetcode.com/problems/product-of-array-except-self/solution/
*/