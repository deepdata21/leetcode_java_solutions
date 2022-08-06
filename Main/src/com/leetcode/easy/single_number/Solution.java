package com.leetcode.easy.single_number;

public class Solution {

    //Given a non-empty array of integers nums, every element appears twice except
    //for one. Find that single one.
    //
    // You must implement a solution with a linear runtime complexity and use only
    //constant extra space.
    //
    //
    // Example 1:
    // Input: nums = [2,2,1]
    //Output: 1
    //
    // Example 2:
    // Input: nums = [4,1,2,1,2]
    //Output: 4
    //
    // Example 3:
    // Input: nums = [1]
    //Output: 1
    //
    //
    // Constraints:
    //
    //
    // 1 <= nums.length <= 3 * 10⁴
    // -3 * 10⁴ <= nums[i] <= 3 * 10⁴
    // Each element in the array appears twice except for one element which appears
    //only once.
    //
    //
    // Related Topics Array Bit Manipulation 👍 10546 👎 394


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int singleNumber(int[] nums) {

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {2,2,1};
        //  O/P: 1

        int[] nums2 = {4,1,2,1,2};
        //  O/P: 4

        int[] nums3 = {1};
        //  O/P: 1

        System.out.println("Example 1: " + singleNumber(nums1));
        System.out.println("Example 2: " + singleNumber(nums2));
        System.out.println("Example 3: " + singleNumber(nums3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

