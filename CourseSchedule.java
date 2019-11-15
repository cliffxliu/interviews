/*
207. Course Schedule (Medium)
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/

class Solution {
    /* Topologically Sort:  linear ordering of its vertices such that for every
    directed edge uv from vertex u to vertex v, u comes before v in the ordering.
    In this case, we put nodes with degree 0 into the queue.
    Decrease the indegree of each node's successor.
    
    Finally, if each node' indgree equals 0, then it is validated DAG (Directed Acyclic Graph).
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Find all nodes with degree 0
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }
        
        //Topological Sort/BFS
        Queue<Integer> queue = new LinkedList<>(); //Set of nodes with no incoming edges
        //Find starting courses (nodes with degree 0)
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            //For each node with an edge from curr to i
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == curr) { //Get the prereq of course i
                    inDegree[prerequisites[i][0]]--; //Ending course indegree--
                    if (inDegree[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }
        
        return true;
        
    }
}