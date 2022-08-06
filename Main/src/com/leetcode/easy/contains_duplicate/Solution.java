package com.leetcode.easy.contains_duplicate;

//import java.util.HashSet;
//import java.util.Set;

public class Solution {
    //Given an integer array nums, return true if any value appears at least twice
    //in the array, and return false if every element is distinct.
    //
    //
    // Example 1:
    // Input: nums = [1,2,3,1]
    //Output: true
    //
    // Example 2:
    // Input: nums = [1,2,3,4]
    //Output: false
    //
    // Example 3:
    // Input: nums = [1,1,1,3,3,4,3,2,4,2]
    //Output: true
    //
    //
    // Constraints:
    //
    //
    // 1 <= nums.length <= 10⁵
    // -10⁹ <= nums[i] <= 10⁹
    //
    //
    // Related Topics Array Hash Table Sorting 👍 5753 👎 989

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static boolean containsDuplicate(int[] nums) {

        java.util.Set<Integer> mySet = new java.util.HashSet<>();

        for (int num : nums) {
            if (mySet.contains(num)) {
                return true;
            } else {
                mySet.add(num);
            }
        }

        return false;

    }

    public static void main(String[] args) {
        // Example 1:
         int[] nums1 = {1,2,3,1};
        //Output: true

        // Example 2:
         int[] nums2 = {1,2,3,4};
        //  O/P: false

        // Example 3:
         int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
        //  O/P: true

        System.out.println(containsDuplicate(nums1));
        System.out.println(containsDuplicate(nums2));
        System.out.println(containsDuplicate(nums3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

