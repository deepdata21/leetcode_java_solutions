package com.leetcode.easy.flood_fill;

import java.util.Arrays;

public class Solution {
    //An image is represented by an m x n integer grid image where image[i][j]
    //represents the pixel value of the image.
    //
    // You are also given three integers sr, sc, and color. You should perform a
    //flood fill on the image starting from the pixel image[sr][sc].
    //
    // To perform a flood fill, consider the starting pixel, plus any pixels
    //connected 4-directionally to the starting pixel of the same color as the starting
    //pixel, plus any pixels connected 4-directionally to those pixels (also with the same
    //color), and so on. Replace the color of all of the aforementioned pixels with
    //color.
    //
    // Return the modified image after performing the flood fill.
    //
    //
    // Example 1:
    //
    //
    //Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
    //Output: [[2,2,2],[2,2,0],[2,0,1]]
    //Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.
    //e., the red pixel), all pixels connected by a path of the same color as the
    //starting pixel (i.e., the blue pixels) are colored with the new color.
    //Note the bottom corner is not colored 2, because it is not 4-directionally
    //connected to the starting pixel.
    //
    //
    // Example 2:
    //
    //
    //Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
    //Output: [[0,0,0],[0,0,0]]
    //Explanation: The starting pixel is already colored 0, so no changes are made
    //to the image.
    //
    //
    //
    // Constraints:
    //
    //
    // m == image.length
    // n == image[i].length
    // 1 <= m, n <= 50
    // 0 <= image[i][j], color < 2¹⁶
    // 0 <= sr < m
    // 0 <= sc < n
    //
    //
    // Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 5134 ?
    //? 506


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        //  Optional, renaming the color to be used to replace
        //      the existing color of the starting cell
        int newColor = color;

        //  Naming color of the starting cell
        //  Since, color of the starting cell is to be replaced
        //      calling it oldColor
        int oldColor = image[sr][sc];

        if (oldColor != newColor) {
            floodFillDFSHelper(image, sr, sc, oldColor, newColor);
        }

        return image;
    }

    private static void floodFillDFSHelper(int[][] image,
                                           int sr, int sc,
                                           int oldColor,
                                           int newColor) {

        //  image.length: gives number of rows---row symbol: sr
        //  image[0].length: gives number of columns---column symbol: sc
        if (sr < 0 || sr >= image.length ||
                sc < 0 || sc >= image[0].length) {
            //  Since the conditions above do not represent
            //      a valid cell
            //  return statement is optional
            //      goes back to the caller method
            return;
        }

        //  Checks if the current cell has the same color
        //      as the original color of the starting cell
        if (image[sr][sc] != oldColor) {
            //  return statement is optional
            //      goes back to the caller method
            return;
        }

        image[sr][sc] = newColor;

        //  4-directional recursion calls
        //  Vertical or Horizontal
        //  NOT diagonal

        //  Vertical Move: Up
        floodFillDFSHelper(image, sr + 1, sc, oldColor, newColor);
         //  Vertical Move: Down
        floodFillDFSHelper(image, sr - 1, sc, oldColor, newColor);
        //  Horizontal Move: Right
        floodFillDFSHelper(image, sr, sc + 1, oldColor, newColor);
        //  Horizontal Move: Left
        floodFillDFSHelper(image, sr, sc - 1, oldColor, newColor);

    }

    public static void main(String[] args) {

        // Example 1:
        int[][] image1 = {{1,1,1},{1,1,0},{1,0,1}};
        int sr1 = 1;
        int sc1 = 1;
        int color1 = 2;
        //  O/P: [[2,2,2],[2,2,0],[2,0,1]]

        // Example 2:
        int[][] image2 = {{0,0,0},{0,0,0}};
        int sr2 = 0;
        int sc2 = 0;
        int color2 = 0;
        //  O/P: [[0,0,0],[0,0,0]]

        System.out.println(Arrays.deepToString(floodFill(image1, sr1, sc1, color1)));
        System.out.println(Arrays.deepToString(floodFill(image2, sr2, sc2, color2)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
