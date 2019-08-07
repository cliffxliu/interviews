/*
253. Meeting Rooms II (Medium)
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:
Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Example 2:
Input: [[7,10],[2,4]]
Output: 1
*/

class Solution {
    /**
    Keep all the rooms in a min heap where the key for the min heap is the ending time of meeting.
    Every time we want to check if a room is free or not, we can check the topmost element of the min heap,
    which is the room that would get free the earliest out of all the other rooms currently occupied.
    If this topmost element is not free, then res++.
    */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int res = 0;
        Comparator<int[]> comp = (int[] a, int[] b) -> (a[0] - b[0]);
        Arrays.sort(intervals, comp);
        
        Comparator<Integer> comp2 = (Integer a, Integer b) -> (a - b);
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length, comp2);
        allocator.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll(); //removes first element
            }
            allocator.add(intervals[i][1]);
        }
        
        return allocator.size();
    }
}

/*
Complexity:
Time: O(NlogN). Both sorting and N extra-min operation on a heap * log N = NlogN
Space: O(N). Min heap that can contain N elements
*/