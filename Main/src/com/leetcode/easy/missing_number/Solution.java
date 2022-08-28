package com.leetcode.easy.missing_number;

public class Solution {
//Given an array nums containing n distinct numbers in the range [0, n], return
//the only number in the range that is missing from the array.
//
//
// Example 1:
//
//
//Input: nums = [3,0,1]
//Output: 2
//Explanation: n = 3 since there are 3 numbers, so all numbers are in the range
//[0,3]. 2 is the missing number in the range since it does not appear in nums.
//
//
// Example 2:
//
//
//Input: nums = [0,1]
//Output: 2
//Explanation: n = 2 since there are 2 numbers, so all numbers are in the range
//[0,2]. 2 is the missing number in the range since it does not appear in nums.
//
//
// Example 3:
//
//
//Input: nums = [9,6,4,2,3,5,7,0,1]
//Output: 8
//Explanation: n = 9 since there are 9 numbers, so all numbers are in the range
//[0,9]. 8 is the missing number in the range since it does not appear in nums.
//
//
//
// Constraints:
//
//
// n == nums.length
// 1 <= n <= 10⁴
// 0 <= nums[i] <= n
// All the numbers of nums are unique.
//
//
//
// Follow up: Could you implement a solution using only O(1) extra space
//complexity and O(n) runtime complexity?
//
// Related Topics Array Hash Table Math Binary Search Bit Manipulation Sorting ?
//? 6708 👎 2937


    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
    static int missingNumber(int[] nums) {

        //  nums.length will always be in the given array
        //      but it won't appear as an index in the for loop
        int missing = nums.length;

        for (int i = 0; i < nums.length; i++) {
            missing ^= nums[i] ^ i;
        }

        return missing;
    }

    public static void main(String[] args) {

        // Example 1:
        int[] nums1 = {3, 0, 1};
        //  O/P: 2

        // Example 2:
        int[] nums2 = {0, 1};
        //  O/P: 2

        // Example 3:
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        //  O/P: 8

        // Example 4:
        int[] nums4 = {2, 0, 3};
        //  O/P: 2
        // 3^2^0^0^1^3^2

        System.out.println("Example 1: " + missingNumber(nums1));
        System.out.println("Example 2: " + missingNumber(nums2));
        System.out.println("Example 3: " + missingNumber(nums3));
        System.out.println("Example 4: " + missingNumber(nums4));

    }
 }

//leetcode submit region end(Prohibit modification and deletion)
