/*
252. Meeting Rooms I (Easy)
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:
Input: [[0,30],[5,10],[15,20]]
Output: false

Example 2:
Input: [[7,10],[2,4]]
Output: true
*/

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Comparator<int[]> comp = (int[] a, int[] b) -> (a[0] - b[0]);
        Arrays.sort(intervals, comp);
        for (int i = 0; i < intervals.length - 1;i++) {
            if (intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;
        
    }
}


/*
Complexity:
Time: O(NlogN). Dominated by sorting. After sorting is done, only O(N) time is needed to go through the array.
Space: O(1). No additional space allocated.
*/