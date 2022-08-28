package com.leetcode.medium.sort_colors;

import java.util.Arrays;

public class Solution {
    //Given an array nums with n objects colored red, white, or blue, sort them in-
    //place so that objects of the same color are adjacent, with the colors in the
    //order red, white, and blue.
    //
    // We will use the integers 0, 1, and 2 to represent the color red, white, and
    //blue, respectively.
    //
    // You must solve this problem without using the library's sort function.
    //
    //
    // Example 1:
    //
    //
    //Input: nums = [2,0,2,1,1,0]
    //Output: [0,0,1,1,2,2]
    //
    //
    // Example 2:
    //
    //
    //Input: nums = [2,0,1]
    //Output: [0,1,2]
    //
    //
    //
    // Constraints:
    //
    //
    // n == nums.length
    // 1 <= n <= 300
    // nums[i] is either 0, 1, or 2.
    //
    //
    //
    // Follow up: Could you come up with a one-pass algorithm using only constant
    //extra space?
    //
    // Related Topics Array Two Pointers Sorting 👍 11777 👎 444


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static void sortColors(int[] nums) {
        int indexLow = 0;
        int indexHigh = nums.length - 1;

        for (int i = 0; i <= indexHigh;) {

            //  Make sure '0' has an index below indexLow
            if (nums[i] == 0) {
                swapElements(nums, i, indexLow);
                i++;
                indexLow++;
            //  Make sure '1' has an index between
            //      indexLow and indexHigh
            } else if (nums[i] == 1) {
                i++;
            //  Make sure '2' has an index above indexHigh
            } else {
                swapElements(nums, i, indexHigh);
                indexHigh--;
            }

        }

        System.out.println(Arrays.toString(nums));
    }

    private static void swapElements (int[] nums, int index, int newIndex) {
        int tempElement = nums[index];
        nums[index] = nums[newIndex];
        nums[newIndex] = tempElement;
    }

    public static void main(String[] args) {

        // Example 1:
        int[] nums1 = {2,0,2,1,1,0};
        //  O/P: [0,0,1,1,2,2]

        // Example 2:
        int[] nums2 = {2,0,1};
        // O/P: [0,1,2]

        sortColors(nums1);
        sortColors(nums2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

