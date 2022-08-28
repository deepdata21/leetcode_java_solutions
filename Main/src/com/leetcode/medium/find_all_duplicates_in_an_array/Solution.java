package com.leetcode.medium.find_all_duplicates_in_an_array;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    //Given an integer array nums of length n where all the integers of nums are in
    //the range [1, n] and each integer appears once or twice, return an array of all
    //the integers that appears twice.
    //
    // You must write an algorithm that runs in O(n) time and uses only constant
    //extra space.
    //
    //
    // Example 1:
    // Input: nums = [4,3,2,7,8,2,3,1]
    //Output: [2,3]
    //
    // Example 2:
    // Input: nums = [1,1,2]
    //Output: [1]
    //
    // Example 3:
    // Input: nums = [1]
    //Output: []
    //
    //
    // Constraints:
    //
    //
    // n == nums.length
    // 1 <= n <= 10⁵
    // 1 <= nums[i] <= n
    // Each element in nums appears once or twice.
    //
    //
    // Related Topics Array Hash Table 👍 7066 👎 272

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static List<Integer> findDuplicates(int[] nums) {

        int index = 0;

        while (index < nums.length) {
            if (nums[index] != nums[nums[index] - 1]) {
                swapElements(nums, index, nums[index] - 1);
            } else {
                index++;
            }
        }

        List<Integer> listOfDuplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                listOfDuplicates.add(nums[i]);
            }
        }

        return listOfDuplicates;
    }

    private static void swapElements (int[] nums, int index, int correctedIndex) {

        int tempElement = nums[index];
        nums[index] = nums[correctedIndex];
        nums[correctedIndex] = tempElement;
    }

    public static void main (String[] args) {

        // Example 1:
        int[] nums1 = {4,3,2,7,8,2,3,1};
        //Output: [2,3]

        // Example 2:
        int[] nums2 = {1,1,2};
        //  O/P: [1]

        // Example 3:
        int[] nums3 = {1};
        //  O/P: []

        System.out.println(findDuplicates(nums1));
        System.out.println(findDuplicates(nums2));
        System.out.println(findDuplicates(nums3));
    }

}

//leetcode submit region end(Prohibit modification and deletion)

