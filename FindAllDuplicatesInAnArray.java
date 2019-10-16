/*
442. Find All Duplicates in an Array (Medium)
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/

class Solution {
    /* Use the array itself as a hashmap */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //For every index a[i], the value at index a[i - 1] will be negated
            //Check if the value at index a[i - 1] is already negative, if so the value at index a[i] is repeated
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(index + 1));
            }
            nums[index] *= -1;
        }
        return res;
    }
}

/*
Complexity:
Time: O(N).
Space: O(1).
*/