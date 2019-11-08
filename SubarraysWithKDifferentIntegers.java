/*
992. Subarrays with K Different Integers (Hard)
Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the number of different integers in that subarray is exactly K.

(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)

Return the number of good subarrays of A.

Example 1:
Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].

Example 2:
Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 
Note:
1 <= A.length <= 20000
1 <= A[i] <= A.length
1 <= K <= A.length
*/

class Solution {
    /*
    We want to keep track of number of subarrays with the same number of distinct integers.
    These subarrays are POTENTIAL candidates of having K distinct integers.
    Add subarrays to res when we have encounteered K distinct integers
    */
    public int subarraysWithKDistinct(int[] A, int K) {
        int res = 0;
        int subArrays = 0; //with same number of distinct integers
        Map<Integer, Integer> map = new HashMap<>(); //Map unique values to counts
        
        for (int i = 0, j = 0; j < A.length; j++) { //Start with 2 pointers at index 0
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            if (map.size() > K) { //If right pointer has exceeded length of array, we exit 
                map.remove(A[i]);
                subArrays = 0;
                i++;
            }
            
            while (map.get(A[i]) > 1) { //Check number at left pointer, if contains duplicates, shrink window
                subArrays++;
                map.put(A[i], map.get(A[i]) - 1);
                i++;
            }
            
            if (map.size() == K) {  //If no duplicates, add prefix + 1 to result
                res += subArrays + 1;
            }
        }
        
        return res;
    }
}