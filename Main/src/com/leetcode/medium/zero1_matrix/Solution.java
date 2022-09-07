package com.leetcode.medium.zero1_matrix;

import java.util.Arrays;

public class Solution {
    //Given an m x n binary matrix mat, return the distance of the nearest 0 for
    //each cell.
    //
    // The distance between two adjacent cells is 1.
    //
    //
    // Example 1:
    //
    //
    //Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
    //Output: [[0,0,0],[0,1,0],[0,0,0]]
    //
    //
    // Example 2:
    //
    //
    //Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
    //Output: [[0,0,0],[0,1,0],[1,2,1]]
    //
    //
    //
    // Constraints:
    //
    //
    // m == mat.length
    // n == mat[i].length
    // 1 <= m, n <= 10⁴
    // 1 <= m * n <= 10⁴
    // mat[i][j] is either 0 or 1.
    // There is at least one 0 in mat.
    //
    //
    // Related Topics Array Dynamic Programming Breadth-First Search Matrix 👍 5531
    //👎 275


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int[][] updateMatrix(int[][] mat) {

        if (mat.length == 0 || mat[0].length == 0) {
            return mat;
        }

        int[][] distMatrix = new int[mat.length][mat[0].length];

        //  Set Integer.MAX_VALUE / 2 as cell values
        //      Divided by 2 to avoid Integer Overflow
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                distMatrix[i][j] = Integer.MAX_VALUE / 2;
            }
        }

        //  Left & Top/Up
        //  From top to bottom and left to right
        //  To check left and top directions
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    distMatrix[i][j] = 0;
                } else {
                    if (i > 0) {
                        distMatrix[i][j] = Math.min(
                                distMatrix[i][j],
                                distMatrix[i - 1][j]) + 1;
                    }

                    if (j > 0) {
                        distMatrix[i][j] = Math.min(
                                distMatrix[i][j],
                                distMatrix[i][j - 1]) + 1;
                    }
                }
            }
        }

        //  Down/Bottom & Right
        //  From Bottom to top and right to left
        //  To check right and bottom directions
        for (int i = mat.length - 1; i >=0 ; i--) {
            for (int j = mat[0].length - 1; j >=0 ; j--) {
                if (i < mat.length - 1) {
                    distMatrix[i][j] = Math.min (
                            distMatrix[i][j],
                            distMatrix[i + 1][j]) + 1;
                }

                if (j < mat[0].length - 1) {
                    distMatrix[i][j] = Math.min (
                            distMatrix[i][j],
                            distMatrix[i][j + 1]) + 1;
                }
            }
        }

        return distMatrix;
    }

    public static void main(String[] args) {
        // Example 1:
        int[][] mat1 = {{0,0,0},{0,1,0},{0,0,0}};
        //Output: [[0,0,0],[0,1,0],[0,0,0]]

        // Example 2:
        int[][] mat2 = {{0,0,0},{0,1,0},{1,1,1}};
        //Output: [[0,0,0],[0,1,0],[1,2,1]]

        // Example 3A:
        int[][] mat3a = {{0},{0},{0}};
        //Output: [[0],[0],[0]]

        // Example 3B:
        int[][] mat3b = {{0},{1},{0}};
        //Output: [[0],[1],[0]]

        // Example 4:
        int[][] mat4 = {{0,0,0}};
        //Output: [[0],[0],[0]]

        // Example 5:
        int[][] mat5 = {{0}};
        //Output: [[0]]

        // Example 6:
        int[][] mat6 = {{}};
        //Output: [[]]

        // Example 6:
        int[][] mat7 = {{1,1,0,0,1,0,0,1,1,0},
                        {1,0,0,1,0,1,1,1,1,1},
                        {1,1,1,0,0,1,1,1,1,0},
                        {0,1,1,1,0,1,1,1,1,1},
                        {0,0,1,1,1,1,1,1,1,0},
                        {1,1,1,1,1,1,0,1,1,1},
                        {0,1,1,1,1,1,1,0,0,1},
                        {1,1,1,1,1,0,0,1,1,1},
                        {0,1,0,1,1,0,1,1,1,1},
                        {1,1,1,0,1,0,1,1,1,1}};

        //  Time Complexity: O(r*c)
        //  Space Complexity: O(1)

        System.out.println(Arrays.deepToString(updateMatrix(mat1)));
        System.out.println(Arrays.deepToString(updateMatrix(mat2)));
        System.out.println(Arrays.deepToString(updateMatrix(mat3a)));
        System.out.println(Arrays.deepToString(updateMatrix(mat3b)));
        System.out.println(Arrays.deepToString(updateMatrix(mat4)));
        System.out.println(Arrays.deepToString(updateMatrix(mat5)));
        System.out.println(Arrays.deepToString(updateMatrix(mat6)));
        System.out.println(Arrays.deepToString(updateMatrix(mat7)));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
