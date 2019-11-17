/*
939. Minimum Area Rectangle (Medium)
Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.

If there isn't any rectangle, return 0.

Example 1:

Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: 4


Example 2:

Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
Output: 2
 

Note:

1 <= points.length <= 500
0 <= points[i][0] <= 40000
0 <= points[i][1] <= 40000
All points are distinct.
*/

class Solution {
    public int minAreaRect(int[][] points) {
        //Map x coordinate to y coordinates. We can check this later to form sides.
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point: points) {
            if (!map.containsKey(point[0])) {
                map.put(point[0], new HashSet<>());
            }
            map.get(point[0]).add(point[1]);
        }
        
        int area = Integer.MAX_VALUE;
        for (int[] p1: points) {
            for (int[] p2: points) {
                if (p1[0] != p2[0] && p1[1] != p2[1]) { //if p1 and p2 can form a diagonal
                    if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) { 
                        /*
                        Find p3 and p4 s.t. p3.x = p2.x, p3.y = p1.y && p4.x = p1.x, p4.y = p2.y
                        (p2[0], p1[1]) and (p1[0], p2[1]) will form p3 and p4)
                        */
                        area = Math.min(area, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                    }
                }
            }
        } 
        
        if (area == Integer.MAX_VALUE) {
            return 0; //if res didn't change
        }
        return area;
    }
}