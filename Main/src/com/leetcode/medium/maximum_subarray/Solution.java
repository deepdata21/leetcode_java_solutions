package com.leetcode.medium.maximum_subarray;

public class Solution {

//Given an integer array nums, find the contiguous subarray (containing at
//least one number) which has the largest sum and return its sum.
//
// A subarray is a contiguous part of an array.
//
//
// Example 1:
//
//
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
//
//
// Example 2:
//
//
//Input: nums = [1]
//Output: 1
//
//
// Example 3:
//
//
//Input: nums = [5,4,-1,7,8]
//Output: 23
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
//
//
//
// Follow up: If you have figured out the O(n) solution, try coding another
//solution using the divide and conquer approach, which is more subtle.
// Related Topics Array Divide and Conquer Dynamic Programming 👍 21970 👎 1094

//Given an integer array nums, find the contiguous subarray (containing at
//least one number) which has the largest sum and return its sum.

    static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
   }

    public static void main(String[] args) {

        //  Output: 6
        //  Explanation: [4,-1,2,1] has the largest sum = 6.
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};

        //  Output: 1
        int[] nums2 = {1};

        //  Output: 23
        int[] nums3 = {5,4,-1,7,8};

        maxSubArray(nums1);
        maxSubArray(nums2);
        maxSubArray(nums3);

        System.out.println("Ex. 1: " + maxSubArray(nums1));
        System.out.println("Ex. 2: " + maxSubArray(nums2));
        System.out.println("Ex. 3: " + maxSubArray(nums3));

    }
}
