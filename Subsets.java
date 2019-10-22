/*
78. Subsets (Medium)
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> currList, int[] nums, int start) {
        res.add(new ArrayList<>(currList));
        for (int i = start; i < nums.length; i++) {
            currList.add(nums[i]);
            backtrack(res, currList, nums, i + 1);
            currList.remove(currList.size() - 1);
        }
    }
}

/*
Time: O(2^N). If we want to add anything, we double number of operations.
Space: O(2^N).
*/