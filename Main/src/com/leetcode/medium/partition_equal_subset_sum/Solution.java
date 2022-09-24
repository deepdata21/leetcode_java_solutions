package com.leetcode.medium.partition_equal_subset_sum;

public class Solution {
    //Given a non-empty array nums containing only positive integers, find if the
    //array can be partitioned into two subsets such that the sum of elements in both
    //subsets is equal.
    //
    //
    // Example 1:
    //
    //
    //Input: nums = [1,5,11,5]
    //Output: true
    //Explanation: The array can be partitioned as [1, 5, 5] and [11].
    //
    //
    // Example 2:
    //
    //
    //Input: nums = [1,2,3,5]
    //Output: false
    //Explanation: The array cannot be partitioned into equal sum subsets.
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= nums.length <= 200
    // 1 <= nums[i] <= 100
    //
    //
    // Related Topics Array Dynamic Programming 👍 8902 👎 149


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static boolean canPartition(int[] nums) {
        //  Check for empty given array of integers (nums)
        //  If nums is empty return false
        if (nums.length == 0) {
            return false;
        }

        //  Declare numsLength to store the length of nums
        //      to make iteration for efficient
        int numsLength = nums.length;

        //  Declare and initialize an integer variable called totalSum
        int totalSum = 0;

        //  Iterate over the given array to find
        //      the total sum of its elements
        //      using a for loop
        for (int i = 0; i < numsLength; i++) {
            totalSum += nums[i];
        }

        //  Since two partitions of equal sum,
        //      totalSum cannot be odd.
        //  If totalSum is odd return false
        if (totalSum % 2 != 0) {
            return false;
        }

        //  Since two partitions of equal sum,
        //      the sum of all elements in each partition
        //      is equal to totalSum / 2.
        //  So, declare equalPartitionSum
        int equalPartitionSum = totalSum / 2;

        //  For memoization, dclare an array to contain boolean values
        boolean[] memo = new boolean[equalPartitionSum + 1];

        //  Set first element of memo to true
        //      since it's an array of sum and at
        //      sum = 0 when following bottom-up approach
        //      it's true
        memo[0] = true;

        //  Iterate over all elements in nums
        for (int num : nums) {
            for (int sum = equalPartitionSum; sum >= num; sum--) {
                //  Perform Bitwise OR operation (|=);
                //      assign memo[sum] the result of
                //      the Bitwise OR operation between
                //      memo[sum] and memo[sum - num]
                //  e.g., if memo[sum] = true or 1 and
                //         memo[sum - num] = false or 0
                //  memo[sum] |= memo[sum - num] gives
                //  memo[sum] = true or 1b;
                //  memo[sum]: dp case excluding current index
                //  memo[sum - sum]: dp case including current index
                //  So, memo[sum] || memo[sum - num] gives the result
                memo[sum] |= memo[sum - num];
            }
        }

        return memo[equalPartitionSum];
    }

    public static void main(String[] args) {
        // Example 1:
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
        //  O/P: true

        // Example 2:
        nums = new int[] {1,2,3,5};
        System.out.println(canPartition(nums));
        //  O/P: false
    }

}
//leetcode submit region end(Prohibit modification and deletion)