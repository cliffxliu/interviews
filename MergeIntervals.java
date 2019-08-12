/*
56. Merge Intervals (Medium)
Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Comparator <int[]> comp = (int[] a, int[] b) -> (a[0] - b[0]);
        Arrays.sort(intervals, comp);
        List<int[]> res = new ArrayList<>();
        
        int[] prevInterval = intervals[0];
        res.add(prevInterval);
        for (int[] interval: intervals) {
            //Changing value of end of prevInterval if current interval start <= prevInterval end
            if (interval[0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(prevInterval[1], interval[1]); 
            } else {
                prevInterval = interval;
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][res.size()]);
        
    }
}

/*
Complexity:
Time: O(NlogN). Dominated by sorting.
Space: O(N). Allocate linear space for ArrayList to store copy of intervals.
*/