package com.leetcode.medium.container_with_most_water;

public class Solution {
    //You are given an integer array height of length n. There are n vertical lines
    //drawn such that the two endpoints of the iᵗʰ line are (i, 0) and (i, height[i]).
    //
    //
    // Find two lines that together with the x-axis form a container, such that the
    //container contains the most water.
    //
    // Return the maximum amount of water a container can store.
    //
    // Notice that you may not slant the container.
    //
    //
    // Example 1:
    //
    //
    //Input: height = [1,8,6,2,5,4,8,3,7]
    //Output: 49
    //Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
    //3,7]. In this case, the max area of water (blue section) the container can
    //contain is 49.
    //
    //
    // Example 2:
    //
    //
    //Input: height = [1,1]
    //Output: 1
    //
    //
    //
    // Constraints:
    //
    //
    // n == height.length
    // 2 <= n <= 10⁵
    // 0 <= height[i] <= 10⁴
    //
    //
    // Related Topics Array Two Pointers Greedy 👍 19626 👎 1047


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int maxArea(int[] height) {

        int leftBoundary = 0;
        int rightBoundary = height.length - 1;
        int maxAreaValue = 0;

        while (leftBoundary < rightBoundary) {

            int width = rightBoundary - leftBoundary;

            maxAreaValue = Math.max(maxAreaValue, Math.min(height[leftBoundary],
                    height[rightBoundary]) * width);

            if (height[leftBoundary] <= height[rightBoundary]) {
                leftBoundary++;
            } else {
                rightBoundary--;
            }

        }

        return maxAreaValue;
    }

    public static void main (String[] args) {

        // Example 1:
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        //  O/P: 49

        // Example 2:
        int[] height2 = {1,1};
        //  O/P: 1

        System.out.println(maxArea(height1));
        System.out.println(maxArea(height2));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

