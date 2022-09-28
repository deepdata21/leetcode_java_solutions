package com.leetcode.medium.rotting_oranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //You are given an m x n grid where each cell can have one of three values:
    //
    //
    // 0 representing an empty cell,
    // 1 representing a fresh orange, or
    // 2 representing a rotten orange.
    //
    //
    // Every minute, any fresh orange that is 4-directionally adjacent to a rotten
    //orange becomes rotten.
    //
    // Return the minimum number of minutes that must elapse until no cell has a
    //fresh orange. If this is impossible, return -1.
    //
    //
    // Example 1:
    //
    //
    //Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
    //Output: 4
    //
    //
    // Example 2:
    //
    //
    //Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
    //Output: -1
    //Explanation: The orange in the bottom left corner (row 2, column 0) is never
    //rotten, because rotting only happens 4-directionally.
    //
    //
    // Example 3:
    //
    //
    //Input: grid = [[0,2]]
    //Output: 0
    //Explanation: Since there are already no fresh oranges at minute 0, the answer
    //is just 0.
    //
    //
    //
    // Constraints:
    //
    //
    // m == grid.length
    // n == grid[i].length
    // 1 <= m, n <= 10
    // grid[i][j] is 0, 1, or 2.
    //
    //
    // Related Topics Array Breadth-First Search Matrix 👍 8393 👎 308

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int orangesRotting(int[][] grid) {
        //  If grid is null or empty return 0
        //      since there are no fresh orange
        //      and no time is elapsed
        if (grid == null || grid.length == 0) {
            return 0;
        }

        //  row indexed from top to bottom
        int bottomBoundary = grid.length;

        //  column indexed from left to right
        int rightBoundary = grid[0].length;

        //  Declare a queue to store the (row, column)
        //      coordinates of all the rotten oranges
        Queue<int[]> bfsQueue = new LinkedList<>();

        //  Declare and initialize a variable
        //      to count all the fresh oranges
        int freshCount = 0;

        //  Iterate over all the grid points/cells
        //      to find and store the rotten oranges
        //      in a queue
        for (int i = 0; i < bottomBoundary; i++) {
            for (int j = 0; j < rightBoundary; j++) {
                if (grid[i][j] == 2) {
                    bfsQueue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    //  If fresh increae the count of
                    //      fresh oranges by 1
                    freshCount++;
                }
            }
        }

        //  If there are no fresh oranges even
        //      at the beginning, return 0
        if (freshCount == 0) {
            return 0;
        }

        //  Declare and initialize a variable
        //      to count elapsed time
        int timeCount = 0;

        //  Declare and define a 2D array to
        //      mark boundary of each BFS step
        //
        //      {-1, 0} : out of bound (row) cell/point
        //      {0, 1}  : right cell/point
        //      {1, 0}  : lower cell/point
        //      {0, -1} : out of bound (column) cell/point
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        //  Iterate over all entries in the bfsQueue
        //      to check the number of fresh oranges
        //      and elapsed time until the bfsQueue is empty
        while (!bfsQueue.isEmpty()) {
            //  Increase the timeCound by 1
            timeCount++;

            //  Store the size of bfsQueue
            //      efficient time management
            //      and keeping the current size unchanged
            int queueSize = bfsQueue.size();

            //  Iterate over all bfsQueue entries
            //      one step at a time
            for (int i = 0; i < queueSize; i++) {
                //  Remove and store the current cell/point
                int[] currentCell = bfsQueue.poll();

                //  Update the current cell consider
                //      for possible directions
                for (int[] direction : directions ) {
                    int newRow = currentCell[0] + direction[0];
                    int newColumn = currentCell[1] + direction[1];

                    //  Ignore/continue if
                    //      newRow/newColumn is out of bound
                    //      or, cell is empty
                    //      or, orange at the new cell is already rotten
                    if (newRow < 0 || newColumn < 0     ||
                        newRow >= bottomBoundary        ||
                        newColumn >= rightBoundary      ||
                        grid[newRow][newColumn] == 0    ||
                        grid[newRow][newColumn] == 2) {
                        continue;
                    }

                    //  Mark the new cell as rotten
                    grid[newRow][newColumn] = 2;

                    //  Add the new cell in the queue
                    bfsQueue.offer(new int[] {newRow, newColumn});

                    //  Decrease the count of fresh oranges
                    freshCount--;
                }
            }
        }
        //  Using a ternary operator return
        //      -1 if there are still fresh oranges remaining
        //      or, elapsed time if there are no rotten oranges
        //      remaining (in latter case decrease timeCount by 1
        //      since, timeCount is increased at the very beginning
        //      of the iteration (at timestep 0)
        return freshCount == 0 ? timeCount - 1 : -1;
    }

    public static void main(String[] args) {
        // Example 1:
        int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
        //  O/P: 4

        // Example 2:
        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        //  O/P: -1

        // Example 3:
        int[][] grid3 = {{0,2}};
        //  O/P: 0

        System.out.println(orangesRotting(grid1));
        System.out.println(orangesRotting(grid2));
        System.out.println(orangesRotting(grid3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
