package com.leetcode.easy.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

//Given an array of integers nums and an integer target, return indices of the
//two numbers such that they add up to target.
//
// You may assume that each input would have exactly one solution, and you may
//not use the same element twice.
//
// You can return the answer in any order.
//
//
// Example 1:
//
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//
// Example 2:
//
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//
//
// Example 3:
//
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
//
//
//
// Constraints:
//
//
// 2 <= nums.length <= 10⁴
// -10⁹ <= nums[i] <= 10⁹
// -10⁹ <= target <= 10⁹
// Only one valid answer exists.
//
//
//
//Follow-up: Can you come up with an algorithm that is less than O(n²) time
//complexity? Related Topics Array Hash Table 👍 33755 👎 1067

//    //  Brute force approach
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    return new int[]{i, j};
//              }
//          }
//        }
//        return null;
//    }

    //  O(N) time complexity
    //  2-pass HashMap
//      static int[] twoSum(int[] nums, int target) {
//          Map<Integer, Integer> hmap = new HashMap<>();
//          for (int i = 0; i < nums.length; i++) {
//              hmap.put(nums[i], i);
//          }
//
//          for (int i = 0; i < nums.length; i++) {
//              int complement = target - nums[i];
//              if (hmap.containsKey(complement) && hmap.get(complement) != i) {
//                  return new int[] {i, hmap.get(complement)};
//              }
//          }
//          return null;
//      }

    //  O(N) time complexity
    //  1-pass HashMap
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hmap.containsKey(complement)) {
                return new int[] {hmap.get(complement), i};
            }
            hmap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        //Output: [0,1]
        int[] nums1 = {2,7,11,15};
        int target1 = 9;

        //Output: [1,2]
        int[] nums2 = {3,2,4};
        int target2 = 6;

        //Output: [0,1]
        int[] nums3 = {3,3};
        int target3 = 6;

        System.out.println(Arrays.toString(twoSum(nums1, target1)));
        System.out.println(Arrays.toString(twoSum(nums2, target2)));
        System.out.println(Arrays.toString(twoSum(nums3, target3)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


