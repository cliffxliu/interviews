/*
973. K Closest Points to Origin
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:
Input: points = [[1,3],[-2,2],[3,5]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
*/

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        //Create a heap of at most size K
        //Organize by largest distance from origin
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] * b[0] + b[1] * b[1] - (a[0] * a[0] + a[1] * a[1]));
        for (int[] point: points) {
            maxHeap.add(point);
            //we must remove if size > K because we don't want to add bigger ones
            if (maxHeap.size() > K) { 
                maxHeap.remove();
            }
        }
        
        int[][] res = new int[K][2];
        while(K > 0) {
        	K--;
            res[K] = maxHeap.remove();
        }
        
        return res;
        
    }
}