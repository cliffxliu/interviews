/*
34. Find First and Last Position of Element in Sorted Array (Medium)
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

class Solution {
    /*
    Binary search to search sorted array.
    */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findStartingIndex(nums, target);
        res[1] = findEndingIndex(nums, target);
        return res;
    }
    
    public int findStartingIndex(int[] nums, int target) {
        int index = -1; //default if target is not found in array
        int start = 0;
        int end = nums.length -1;
        
        while (start <= end) {
            int midpoint = start + (end - start) / 2; //Avoids overflow
            if (nums[midpoint] >= target) { //Find leftmost index, keep going to left
                end = midpoint - 1;
            } else {
                start = midpoint + 1;
            }
            
            if (nums[midpoint] == target) {
                index = midpoint;
            }
        }
        return index;
    }
    
    public int findEndingIndex(int[] nums, int target) {
        int index = -1; 
        int start = 0;
        int end = nums.length -1;
        
        while (start <= end) {
            int midpoint = start + (end - start) / 2; 
            if (nums[midpoint] <= target) { //Find rightmost index, keep going right
                start = midpoint + 1; //Only difference in logic
            } else {
                end = midpoint - 1;
            }
    
            if (nums[midpoint] == target) {
                index = midpoint;
            }
        }
        return index;
    }
}

/*
Complexity:
Time: O(logN). Binary Search. Search space is halved each time.
Space: O(1)
*/