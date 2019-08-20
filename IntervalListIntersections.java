/*
986. Interval List Intersections (Medium)
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

Example 1:
Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
*/

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        //if sorting is needed, 
        /* 
        Comparator<int[]> comp = (int[] a, int[] b) -> (a[0] - b[0]);
        Arrays.sort(A, comp);
        Arrays.sort(B, comp);
        */
        
        int i = 0; //keeps track of A
        int j = 0; //keeps track of B
        List<int[]> res = new ArrayList<>();
        
        while (i < A.length && j < B.length) {
            int startMax = Math.max(A[i][0], B[j][0]);
            int endMin = Math.min(A[i][1], B[j][1]);
            if (startMax <= endMin) {
                res.add(new int[]{startMax, endMin});
            }
            
            /* We can ignore after we hit the endMin in either interval (A or B) */
            if (A[i][1] == endMin) { //If A[0][1] is the smallest endpoint, only A[1] only intersect B[0]
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][res.size()]);
    }
}

/*
Complexity:
Time: O(A.length + B.length)
Space: O(A.length + B.length)
*/