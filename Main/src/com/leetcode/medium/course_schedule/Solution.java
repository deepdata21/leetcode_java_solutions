package com.leetcode.medium.course_schedule;

import java.util.*;

public class Solution {
    //There are a total of numCourses courses you have to take, labeled from 0 to
    //numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
    // bi] indicates that you must take course bi first if you want to take course ai.
    //
    //
    //
    // For example, the pair [0, 1], indicates that to take course 0 you have to
    //first take course 1.
    //
    //
    // Return true if you can finish all courses. Otherwise, return false.
    //
    //
    // Example 1:
    //
    //
    //Input: numCourses = 2, prerequisites = [[1,0]]
    //Output: true
    //Explanation: There are a total of 2 courses to take.
    //To take course 1 you should have finished course 0. So it is possible.
    //
    //
    // Example 2:
    //
    //
    //Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
    //Output: false
    //Explanation: There are a total of 2 courses to take.
    //To take course 1 you should have finished course 0, and to take course 0 you
    //should also have finished course 1. So it is impossible.
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= numCourses <= 2000
    // 0 <= prerequisites.length <= 5000
    // prerequisites[i].length == 2
    // 0 <= ai, bi < numCourses
    // All the pairs prerequisites[i] are unique.
    //
    //
    // Related Topics Depth-First Search Breadth-First Search Graph Topological
    //Sort 👍 11238 👎 438

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> sortedCourses = new ArrayList<>();
        if (numCourses <= 0) {
            return true;
        }

        //  Store nodes and (corresponing) counts of incoming edges
        Map<Integer, Integer> incomingDegree = new HashMap<>();

        //  Create Map to build an adjaceny list
        Map<Integer, List<Integer>> adjacencyListMap = new HashMap<>();

        for (int courseNode = 0; courseNode < numCourses; courseNode++) {
            incomingDegree.put(courseNode, 0);
            adjacencyListMap.put(courseNode, new ArrayList<>());
        }

        for (int courseNode = 0; courseNode < prerequisites.length;
             courseNode++) {
            int parentClass = prerequisites[courseNode][0];
            int childClass = prerequisites[courseNode][1];
            //  add childClass (prerequisite class) to the
            //      value given as a ArrayList corresponding
            //      to the parentClass marked as the key
            adjacencyListMap.get(parentClass).add(childClass);
            incomingDegree.put(childClass, incomingDegree.get(childClass) + 1);
        }

        //  Create a queue to add source nodes,
        //     meaning nodes with 0 child/incomingDegree
        Queue<Integer> nodeSources = new LinkedList<>();

        for (Map.Entry<Integer, Integer> eSet : incomingDegree.entrySet()) {
            if (eSet.getValue() == 0) {
               nodeSources.add(eSet.getKey());
            }
        }

        //  Add the source nodes to the sortedCourses ArrayList
        while (!nodeSources.isEmpty()) {
            int courseNode = nodeSources.poll();
            sortedCourses.add(courseNode);

            //  Decrease the courseNode's child/children's
            //      incomingDegree map

            //  Create the list of children nodes from the
            //      adjacencyListMap
            List<Integer> childrenNodes = adjacencyListMap.get(courseNode);
            for (int childNode : childrenNodes) {
                incomingDegree.put(childNode,
                        incomingDegree.get(childNode) - 1);
                if (incomingDegree.get(childNode) == 0){
                    nodeSources.add(childNode);
                }
            }
        }

        if (sortedCourses.size() == numCourses) {
            return true;
        } else {
             return false;
        }

    }

    public static void main(String[] args) {
        // Example 1:
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        //  O/P: true

        // Example 2:
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1,0},{0,1}};
        //  O/P: false

        // Example 3:
        int numCourses3 = 0;
        int[][] prerequisites3 = {{}};
        //  O/P: false

        System.out.println(canFinish(numCourses1, prerequisites1));
        System.out.println(canFinish(numCourses2, prerequisites2));
        System.out.println(canFinish(numCourses3, prerequisites3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

