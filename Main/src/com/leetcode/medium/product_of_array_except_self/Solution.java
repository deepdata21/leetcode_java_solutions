package com.leetcode.medium.product_of_array_except_self;

import java.util.Arrays;

public class Solution {
    //Given an integer array nums, return an array answer such that answer[i] is
    //equal to the product of all the elements of nums except nums[i].
    //
    // The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
    //integer.
    //
    // You must write an algorithm that runs in O(n) time and without using the
    //division operation.
    //
    //
    // Example 1:
    // Input: nums = [1,2,3,4]
    //Output: [24,12,8,6]
    //
    // Example 2:
    // Input: nums = [-1,1,0,-3,3]
    //Output: [0,0,9,0,0]
    //
    //
    // Constraints:
    //
    //
    // 2 <= nums.length <= 10⁵
    // -30 <= nums[i] <= 30
    // The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
    //integer.
    //
    //
    //
    // Follow up: Can you solve the problem in O(1) extra space complexity? (The
    //output array does not count as extra space for space complexity analysis.)
    //
    // Related Topics Array Prefix Sum 👍 13909 👎 796


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        int rightSide = 1;

        //  Find products of elements on the left side of index i
        //  At the end of the loop, only the last element of result
        //     (result[nums.length - 1]) has the correct element
        //  NOTE: loop doesn't update the first element of result
        for (int i = 1; i <= nums.length - 1; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        //  Multiply left-side products with the right-side products
        //      to get the desired result
        //  At the start of the loop,
        //     only result[nums.length] has the correct element
        //  NOTE: At the first step of the loop, the last element of result
        //      (result[nums.length - 1]) stays the same
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * rightSide;
            rightSide *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        // Example 1:
        int[] nums1 = {1, 2, 3, 4};
        //  O/P: [24,12,8,6]

        // Example 2:
        int[] nums2 = {-1, 1, 0, -3, 3};
        //  O/P: [0,0,9,0,0]

        System.out.println(Arrays.toString(productExceptSelf(nums1)));
        System.out.println(Arrays.toString(productExceptSelf(nums2)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
