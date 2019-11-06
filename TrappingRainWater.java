/*
42. Trapping Rain Water (Hard)
Given n non-negative integers representing an elevation map where the width of 
each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. 

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        
        //Calculate maxes as these form the "perimeter" of the "bowl"
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        
        //First pass: Calculate left perimeters
        leftMax[0] = height[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        
        //Second pass: Calculate right perimeters
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        
        //Third pass: Sum up and subtract currHeight (the height of the pool at that point)
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return res;
         
    }
}