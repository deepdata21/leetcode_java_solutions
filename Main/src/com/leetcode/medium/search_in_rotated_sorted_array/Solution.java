package com.leetcode.medium.search_in_rotated_sorted_array;

public class Solution {
    //There is an integer array nums sorted in ascending order (with distinct
    //values).
    //
    // Prior to being passed to your function, nums is possibly rotated at an
    //unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k]
    //, nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For
    //example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0
    //,1,2].
    //
    // Given the array nums after the possible rotation and an integer target,
    //return the index of target if it is in nums, or -1 if it is not in nums.
    //
    // You must write an algorithm with O(log n) runtime complexity.
    //
    //
    // Example 1:
    // Input: nums = [4,5,6,7,0,1,2], target = 0
    //Output: 4
    //
    // Example 2:
    // Input: nums = [4,5,6,7,0,1,2], target = 3
    //Output: -1
    //
    // Example 3:
    // Input: nums = [1], target = 0
    //Output: -1
    //
    //
    // Constraints:
    //
    //
    // 1 <= nums.length <= 5000
    // -10⁴ <= nums[i] <= 10⁴
    // All values of nums are unique.
    // nums is an ascending array that is possibly rotated.
    // -10⁴ <= target <= 10⁴
    //
    //
    // Related Topics Array Binary Search 👍 17175 👎 1036


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int search(int[] nums, int target) {

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (target == nums[middleIndex]) {
                return middleIndex;
            }

            if (nums[startIndex] <= nums[middleIndex]) {
                if (target >= nums[startIndex] && target < nums[middleIndex]) {
                    endIndex = middleIndex - 1;
                } else {
                    startIndex = middleIndex + 1;
                }

            } else {
                if (target < nums[startIndex] && target >= nums[middleIndex]) {
                    startIndex = middleIndex + 1;
                } else {
                    endIndex = middleIndex - 1;
                }
            }
        }

        return -1;
    }

    public static void main (String[] args) {

        // Example 1:
        int[] nums1 = {4,5,6,7,0,1,2};
        int target1 = 0;
        //  O/P: 4

        // Example 2:
        int[] nums2 = {4,5,6,7,0,1,2};
        int target2 = 3;
        //  O/P: -1

        // Example 3:
        int[] nums3 = {1};
        int target3 = 0;
        //  O/P: -1

        System.out.println(search(nums1,target1));
        System.out.println(search(nums2,target2));
        System.out.println(search(nums3,target3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
