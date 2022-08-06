package com.leetcode.easy.majority_element;

import java.util.Arrays;

public class Solution {
    //Given an array nums of size n, return the majority element.
    //
    // The majority element is the element that appears more than ⌊n / 2⌋ times.
    //You may assume that the majority element always exists in the array.
    //
    //
    // Example 1:
    // Input: nums = [3,2,3]
    //Output: 3
    //
    // Example 2:
    // Input: nums = [2,2,1,1,1,2,2]
    //Output: 2
    //
    //
    // Constraints:
    //
    //
    // n == nums.length
    // 1 <= n <= 5 * 10⁴
    // -10⁹ <= nums[i] <= 10⁹
    //
    //
    //
    //Follow-up: Could you solve the problem in linear time and in
    //O(1) space?
    //
    // Related Topics Array Hash Table Divide and Conquer Sorting Counting 👍 10799
    //👎 360

    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int majorityElement(int[] nums) {

//        //  Approach #1
//        Arrays.sort(nums);
//        return nums[nums.length/2];

        //  Approach #2
        //  Boyer-Moore Voting Algorithm

        int count = 0;
        Integer majorCandidate = null;

        for (int num : nums) {
            if (count == 0) {
                majorCandidate = num;
            }

            count += (num == majorCandidate) ? 1 : -1;

        }

        return majorCandidate;
    }

    public static void main(String[] args) {
        // Example 1:
        int[] nums1 = {3,2,3};
        //  O/P: 3
        //
        // Example 2:
        int[] nums2 = {2,2,1,1,1,2,2};
        //  O/P: 2

        System.out.println("Example 1: " + majorityElement(nums1));
        System.out.println("Example 2: " + majorityElement(nums2));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

