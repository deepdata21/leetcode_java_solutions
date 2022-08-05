package com.leetcode.easy.binary_search;

public class Solution {
    //Given an array of integers nums which is sorted in ascending order, and an
    //integer target, write a function to search target in nums. If target exists, then
    //return its index. Otherwise, return -1.
    //
    // You must write an algorithm with O(log n) runtime complexity.
    //
    //
    // Example 1:
    //
    //
    //Input: nums = [-1,0,3,5,9,12], target = 9
    //Output: 4
    //Explanation: 9 exists in nums and its index is 4
    //
    //
    // Example 2:
    //
    //
    //Input: nums = [-1,0,3,5,9,12], target = 2
    //Output: -1
    //Explanation: 2 does not exist in nums so return -1
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= nums.length <= 10⁴
    // -10⁴ < nums[i], target < 10⁴
    // All the integers in nums are unique.
    // nums is sorted in ascending order.
    //
    //
    // Related Topics Array Binary Search 👍 5804 👎 135


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int search(int[] nums, int target) {
        int pivot;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            pivot = left + (right - left) / 2;

            if (nums[pivot] == target) {
                return pivot;
            }

            if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // Example 1:
        int[] nums1 = {-1,0,3,5,9,12};
        int target1 = 9;
        //  O/P: 4

        // Example 2:
        int[] nums2 = {-1,0,3,5,9,12};
        int target2 = 2;
        //  O/P: -1

        System.out.println(search(nums1, target1));
        System.out.println(search(nums2, target2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
