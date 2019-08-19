/* 215. Kth Largest Element in an Array (Medium)
Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

/* Add nums to a max-heap, then poll (retrieves and removes the head (largest) k - 1 times. */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        /* Max Heap --> use Collections.reverseOrder() */
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //no parameters means minHeap
        for (int num: nums) {
            pq.add(num);
        }
        
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.poll();
    }
}

/*
Complexity:
Time: O(NlogN)
Space: O(N)
*/