package com.leetcode.easy.squares_of_a_sorted_array;

import java.util.Arrays;

public class Solution {
    //Given an integer array nums sorted in non-decreasing order, return an array
    //of the squares of each number sorted in non-decreasing order.
    //
    //
    // Example 1:
    //
    //
    //Input: nums = [-4,-1,0,3,10]
    //Output: [0,1,9,16,100]
    //Explanation: After squaring, the array becomes [16,1,0,9,100].
    //After sorting, it becomes [0,1,9,16,100].
    //
    //
    // Example 2:
    //
    //
    //Input: nums = [-7,-3,2,3,11]
    //Output: [4,9,9,49,121]
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= nums.length <= 10⁴
    // -10⁴ <= nums[i] <= 10⁴
    // nums is sorted in non-decreasing order.
    //
    //
    //
    //Follow up: Squaring each element and sorting the new array is very trivial,
    //could you find an
    //O(n) solution using a different approach?
    //
    // Related Topics Array Two Pointers Sorting 👍 6348 👎 163


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int[] sortedSquares(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int[] squaredArray = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[leftIndex]) < Math.abs(nums[rightIndex])) {
                squaredArray[i] = nums[rightIndex] * nums[rightIndex];
                rightIndex--;
            } else {
               squaredArray[i] = nums[leftIndex] * nums[leftIndex];
               leftIndex++;
            }
        }

        return squaredArray;
    }

    public static void main(String[] args) {
        // Example 1:
        int[] nums1 = {-4,-1,0,3,10};
        //  O/P: [0,1,9,16,100]

        // Example 2:
        int[] nums2 = {-7,-3,2,3,11};
        //  O/P: [4,9,9,49,121]

        System.out.println(Arrays.toString(sortedSquares(nums1)));
        System.out.println(Arrays.toString(sortedSquares(nums2)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

