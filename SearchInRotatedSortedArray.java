/*
33. Search in Rotated Sorted Array (Medium)
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4


Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

class Solution {
    /*
    1. Find minimum element (the pivot) index
    2. Apply binary search:
        a. If num lies between index 0 and pivot - 1 position, binary search between 0 and pivot - 1
        b. If num lies between pivot and last element, binary search between pivot and end
    */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int pivot = findPivot(nums);
        
        if (pivot <= 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        
        //Search left side of pivot
        if (target >= nums[0] && target <= nums[pivot - 1]) {
            return binarySearch(nums, 0, pivot - 1, target);
        }
        //Search right side of pivot
        else {
            return binarySearch(nums, pivot, nums.length - 1, target);
        }   
    }
    
    // Returns minimum element index
    private int findPivot(int[] array) {
        if (array.length == 1 || array[0] < array[array.length -1]) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > array[mid + 1]) {
                return mid + 1;
            } else if (array[start] <= array[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
    
    private int binarySearch(int[] array, int start, int end, int num) {
        if (num < array[start] || num > array[end]) {
            return -1;
        }
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == num) {
                return mid;
            } else if (num < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}