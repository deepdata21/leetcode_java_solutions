package com.leetcode.medium.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
    //k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    //
    // Notice that the solution set must not contain duplicate triplets.
    //
    //
    // Example 1:
    //
    //
    //Input: nums = [-1,0,1,2,-1,-4]
    //Output: [[-1,-1,2],[-1,0,1]]
    //Explanation:
    //nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    //nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    //nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    //The distinct triplets are [-1,0,1] and [-1,-1,2].
    //Notice that the order of the output and the order of the triplets does not
    //matter.
    //
    //
    // Example 2:
    //
    //
    //Input: nums = [0,1,1]
    //Output: []
    //Explanation: The only possible triplet does not sum up to 0.
    //
    //
    // Example 3:
    //
    //
    //Input: nums = [0,0,0]
    //Output: [[0,0,0]]
    //Explanation: The only possible triplet sums up to 0.
    //
    //
    //
    // Constraints:
    //
    //
    // 3 <= nums.length <= 3000
    // -10⁵ <= nums[i] <= 10⁵
    //
    //
    // Related Topics Array Two Pointers Sorting 👍 20337 👎 1919

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> tripletList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //  -nums[i] is the negative of one of the triplets that add up to zero
            //  Hence, -nums[i] should be equal to twoSum (sum of the remaining 2 triplets)
            //      calculated in the findTriplets method below
            findTriplets(nums, -nums[i], i + 1, tripletList);
        }
        return tripletList;
    }

    //  leftPointer < rightPointer
    static void findTriplets (int[] nums,
                             int twoSum,
                             int leftPointer,
                             List<List<Integer>> tripletList) {
        int rightPointer = nums.length - 1;

        while (leftPointer < rightPointer) {
            int currentSum = nums[leftPointer] + nums[rightPointer];
            if (currentSum == twoSum) {
                tripletList.add(List.of(-twoSum,
                        nums[leftPointer],
                        nums[rightPointer]));
                leftPointer++;
                rightPointer--;
                while (leftPointer < rightPointer &&
                        nums[leftPointer] == nums[leftPointer - 1]) {
                    leftPointer++;
                }
                while (leftPointer < rightPointer &&
                        nums[rightPointer] == nums[rightPointer + 1]) {
                    rightPointer--;
                }
            } else if (twoSum > currentSum) {
                //  Needs to increase currentSum
                leftPointer++;
            } else {
                //  Needs to decrease currentSum
                rightPointer--;
            }
        }
    }

    public static void main(String[] args) {

        // Example 1:
        int[] nums1 = {-1,0,1,2,-1,-4};
        //Output: [[-1,-1,2],[-1,0,1]]

        // Example 2:
        int[] nums2 = {0,1,1};
        //Output: []

        // Example 3:
        int[] nums3 = {0,0,0};
        //Output: [[0,0,0]]

        System.out.println(threeSum(nums1));
        System.out.println(threeSum(nums2));
        System.out.println(threeSum(nums3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
