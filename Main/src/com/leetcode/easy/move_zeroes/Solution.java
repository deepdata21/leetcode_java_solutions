package com.leetcode.easy.move_zeroes;

import java.util.Arrays;

public class Solution {

//Given an integer array nums, move all 0's to the end of it while maintaining
//the relative order of the non-zero elements.
//
// Note that you must do this in-place without making a copy of the array.
//
//
// Example 1:
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
//
// Example 2:
// Input: nums = [0]
//Output: [0]
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁴
// -2³¹ <= nums[i] <= 2³¹ - 1
//
//
//
//Follow up: Could you minimize the total number of operations done?
//
// Related Topics Array Two Pointers 👍 9997 👎 255


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int[] moveZeroes(int[] nums) {

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //  Postfix - a++ : add 1 to "a" and returns the OLD value
                //  Prefix - ++a : add 1 to "a" and returns the NEW value
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

        return nums;
    }

    public static void main(String[] args) {

        // Example 1:
        int[] nums1 = {0, 1, 0, 3, 12};
        //Output: [1,3,12,0,0]

        // Example 2:
        int[] nums2 = {0};
        //Output: [0]

        System.out.println(Arrays.toString(moveZeroes(nums1)));
        System.out.println(Arrays.toString(moveZeroes(nums2)));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

