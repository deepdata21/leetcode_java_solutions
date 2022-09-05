package com.leetcode.medium.number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //Given an m x n 2D binary grid grid which represents a map of '1's (land) and
    //'0's (water), return the number of islands.
    //
    // An island is surrounded by water and is formed by connecting adjacent lands
    //horizontally or vertically. You may assume all four edges of the grid are all
    //surrounded by water.
    //
    //
    // Example 1:
    //
    //
    //Input: grid = [
    //  ["1","1","1","1","0"],
    //  ["1","1","0","1","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","0","0","0"]
    //]
    //Output: 1
    //
    //
    // Example 2:
    //
    //
    //Input: grid = [
    //  ["1","1","0","0","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","1","0","0"],
    //  ["0","0","0","1","1"]
    //]
    //Output: 3
    //
    //
    //
    // Constraints:
    //
    //
    // m == grid.length
    // n == grid[i].length
    // 1 <= m, n <= 300
    // grid[i][j] is '0' or '1'.
    //
    //
    // Related Topics Array Depth-First Search Breadth-First Search Union Find
    //Matrix 👍 16744 👎 385

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    private static void visitedIslandsBFS(char[][] grid, int r, int c) {
        Queue<int[]> visitedLands = new LinkedList<>();
        visitedLands.add(new int[] {r, c});

        while (!visitedLands.isEmpty()) {
            int row = visitedLands.peek()[0];
            int column = visitedLands.peek()[1];

            //  Queue is FIFO:
            //      first in first out
            visitedLands.remove();

            //  Check for valid cells
            if (row < 0 || row >= grid.length ||
                column < 0 || column >= grid[0].length) {
                continue;
            }
            //  Check for water
            if (grid[row][column] == '0') {
                continue;
            }

            //  Mark as visited Land: switching land to water
            grid[row][column] = '0';

            //  Add adjacent cells horizontally or vertically
            visitedLands.add(new int[] {row - 1, column }); //  move up 1 cell
            visitedLands.add(new int[] {row + 1, column });  //  move down 1 cell
            visitedLands.add(new int[] {row, column - 1});  //  move left 1 cell
            visitedLands.add(new int[] {row, column + 1});  //  move right 1 cell
        }
    }

    public static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numberOfIslands = 0;

        //   rowLength = grid.length;
        for (int rowNum = 0; rowNum < grid.length; rowNum++) {
            //  columnLength = grid[0].length;
            for (int columnNum = 0; columnNum < grid[0].length; columnNum++) {
                if (grid[rowNum][columnNum] == '1') {
                    numberOfIslands++;
                    visitedIslandsBFS(grid, rowNum, columnNum);
                }
            }
        }
        return numberOfIslands;
    }

    public static void main(String[] args) {
        // Example 1:
        char[][] grid1 = {
                            {'1','1','1','1','0'},
                            {'1','1','0','1','0'},
                            {'1','1','0','0','0'},
                            {'0','0','0','0','0'}
                        };
        //  O/P: 1

        // Example 2:
        char[][] grid2 = {
                            {'1','1','0','0','0'},
                            {'1','1','0','0','0'},
                            {'0','0','1','0','0'},
                            {'0','0','0','1','1'}
                        };
        //  O/P: 3

        System.out.println(numIslands(grid1));
        System.out.println(numIslands(grid2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

