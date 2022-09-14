package com.leetcode.hard.trapping_rain_water;

public class Solution {
    //Given n non-negative integers representing an elevation map where the width
    //of each bar is 1, compute how much water it can trap after raining.
    //
    //
    // Example 1:
    //
    //
    //Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    //Output: 6
    //Explanation: The above elevation map (black section) is represented by array [
    //0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
    //are being trapped.
    //
    //
    // Example 2:
    //
    //
    //Input: height = [4,2,0,3,2,5]
    //Output: 9
    //
    //
    //
    // Constraints:
    //
    //
    // n == height.length
    // 1 <= n <= 2 * 10⁴
    // 0 <= height[i] <= 10⁵
    //
    //
    // Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack ?
    //? 21116 👎 292


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int trap(int[] height) {
        int leftIndex = 0;
        int leftMax = 0;
        int rightIndex = height.length - 1;
        int rightMax = 0;
        int result = 0;

        while (leftIndex < rightIndex) {
            if (height[leftIndex] < height[rightIndex]) {
                if (height[leftIndex] >= leftMax) {
                    leftMax = height[leftIndex];
                } else {
                    result += leftMax - height[leftIndex];
                }
                leftIndex++;
            } else {
                 if (height[rightIndex] >= rightMax) {
                    rightMax = height[rightIndex];
                 } else {
                    result += rightMax - height[rightIndex];
                 }
                 rightIndex--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example 1:
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        //Output: 6

        // Example 2:
        int[] height2 = {4,2,0,3,2,5};
        //  O/P: 9

        System.out.println(trap(height1));
        System.out.println(trap(height2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

