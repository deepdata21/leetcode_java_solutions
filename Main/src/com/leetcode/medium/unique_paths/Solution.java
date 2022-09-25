package com.leetcode.medium.unique_paths;

import java.util.Arrays;

public class Solution {
    //There is a robot on an m x n grid. The robot is initially located at the top-
    //left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right
    //corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at
    //any point in time.
    //
    // Given the two integers m and n, return the number of possible unique paths
    //that the robot can take to reach the bottom-right corner.
    //
    // The test cases are generated so that the answer will be less than or equal
    //to 2 * 10⁹.
    //
    //
    // Example 1:
    //
    //
    //Input: m = 3, n = 7
    //Output: 28
    //
    //
    // Example 2:
    //
    //
    //Input: m = 3, n = 2
    //Output: 3
    //Explanation: From the top-left corner, there are a total of 3 ways to reach
    //the bottom-right corner:
    //1. Right -> Down -> Down
    //2. Down -> Down -> Right
    //3. Down -> Right -> Down
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= m, n <= 100
    //
    //
    // Related Topics Math Dynamic Programming Combinatorics 👍 11774 👎 348


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int uniquePaths(int m, int n) {
//        //  Approach 1: Brute-force recursive method
//        if (m == 1 || n == 1) {
//            return 1;
//        }
//        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);

        //  Approach 2: Dynamic Programming (optimized recursion)

        //  Declare 2D dp array/memo to store previous results
        //      so that these can be used later if
        //      the same cell (m, n) is encountered again
        //  m = row; n = column
        int[][] dp = new int[m][n];

        //  Set all cells to have a value of 1
        for (int[] array : dp) {
            Arrays.fill(array, 1);
        }

        //  Iterate over all cells following a top-down
        //      approach
        //  NOTE: both row and column starts at index 1
        //  dp[0][1] or dp[0][column] or dp[0][1] or dp[row][0]
        //      is 1 since all cells set to 1
        //      in the for-each loop above
        //  That is, number of paths = 1 for the first row/column
        for (int row = 1; row < m; row++) {
             for (int column = 1; column < n; column++) {
                 // dp [currentRow][currentColumn] is obtained adding
                 //     dp [previousRow][currentColumn] and
                 //     dp [currentRow][previousColumn]
                 dp [row][column] = dp [row - 1][column] + dp [row][column - 1];
             }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // Example 1:
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
        //  O/P: 28

    // Example 2:
        m = 3;
        n = 2;
        System.out.println(uniquePaths(m, n));
        //  O/P: 3

    }
}
//leetcode submit region end(Prohibit modification and deletion)

