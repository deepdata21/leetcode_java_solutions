package com.leetcode.easy.find_the_middle_index_in_array;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    //Given a 0-indexed integer array nums, find the leftmost middleIndex (i.e.,
    //the smallest amongst all the possible ones).
    //
    // A middleIndex is an index where nums[0] + nums[1] + ... + nums[middleIndex-1]
    // == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1].
    //
    // If middleIndex == 0, the left side sum is considered to be 0. Similarly, if
    //middleIndex == nums.length - 1, the right side sum is considered to be 0.
    //
    // Return the leftmost middleIndex that satisfies the condition, or -1 if there
    //is no such index.
    //
    //
    // Example 1:
    //
    //
    //Input: nums = [2,3,-1,8,4]
    //Output: 3
    //Explanation: The sum of the numbers before index 3 is: 2 + 3 + -1 = 4
    //The sum of the numbers after index 3 is: 4 = 4
    //
    //
    // Example 2:
    //
    //
    //Input: nums = [1,-1,4]
    //Output: 2
    //Explanation: The sum of the numbers before index 2 is: 1 + -1 = 0
    //The sum of the numbers after index 2 is: 0
    //
    //
    // Example 3:
    //
    //
    //Input: nums = [2,5]
    //Output: -1
    //Explanation: There is no valid middleIndex.
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= nums.length <= 100
    // -1000 <= nums[i] <= 1000
    //
    //
    //
    // Note: This question is the same as 724: https://leetcode.com/problems/find-
    //pivot-index/
    //
    // Related Topics Array Prefix Sum 👍 664 👎 26


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int findMiddleIndex(int[] nums) {

        int totalSum = 0;
        int leftSum = 0;

        //  Approach 1: Time - 0(n) and Space O(1)
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        for (int i = 0; i < nums.length; leftSum += nums[i++]) {
            //  nums[0] + nums[1] + ... + nums[middleIndex-1] ==
            //      nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1]
            //  NOTE: nums[middleIndex] is left out
            //  And, leftSum = rightSum where totalSum = leftSum + rightSum + nums[i]
            if (leftSum * 2 == totalSum - nums[i]) {
                return i;
            }
        }

        return -1;

//        //  Approach 2: Time - 0(n) and Space O(n)
//        Map<Integer, Integer> myMap = new HashMap<>();
//
//        for (int i = 0; i < nums.length; leftSum += nums[i++]) {
//            //  nums[0] + nums[1] + ... + nums[middleIndex-1] ==
//            //      nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1]
//            //  NOTE: nums[middleIndex] is left out
//            //  And, leftSum = rightSum where totalSum = leftSum + rightSum + nums[i]
//            System.out.println(leftSum);
//            myMap.putIfAbsent(leftSum * 2 + nums[i], i);
//        }
//
//        System.out.println(myMap);
//        //  After the last iteration leftSum = totalSum
//        //  So, if get value from myMap if key matches leftSum
//        //      which is now, at the end, equal to totalSum
//        return myMap.getOrDefault(leftSum, -1);
    }

    public static void main(String[] args) {

        // Example 1:
        int[] nums1 = {2,3,-1,8,4};
        //  O/P: 3

        // Example 2:
        int[] nums2 = {1,-1,4};
        //  O/P: 2

        // Example 3:
        int[] nums3 = {2,5};
        //  O/P: -1

        System.out.println(findMiddleIndex(nums1));
        System.out.println(findMiddleIndex(nums2));
        System.out.println(findMiddleIndex(nums3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

