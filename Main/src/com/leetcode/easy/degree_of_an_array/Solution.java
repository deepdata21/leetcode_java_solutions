package com.leetcode.easy.degree_of_an_array;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Solution {
    //Given a non-empty array of non-negative integers nums, the degree of this
    //array is defined as the maximum frequency of any one of its elements.
    //
    // Your task is to find the smallest possible length of a (contiguous) subarray
    //of nums, that has the same degree as nums.
    //
    //
    // Example 1:
    //
    //
    //Input: nums = [1,2,2,3,1]
    //Output: 2
    //Explanation:
    //The input array has a degree of 2 because both elements 1 and 2 appear twice.
    //Of the subarrays that have the same degree:
    //[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
    //The shortest length is 2. So return 2.
    //
    //
    // Example 2:
    //
    //
    //Input: nums = [1,2,2,3,1,4,2]
    //Output: 6
    //Explanation:
    //The degree is 3 because the element 2 is repeated 3 times.
    //So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
    //
    //
    //
    // Constraints:
    //
    //
    // nums.length will be between 1 and 50,000.
    // nums[i] will be an integer between 0 and 49,999.
    //
    //
    // Related Topics Array Hash Table 👍 2203 👎 1367


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> leftBoundary = new HashMap<>();
        Map<Integer, Integer> rightBoundary = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        int result = nums.length;

        for (int i = 0; i < nums.length; i++) {

            if (leftBoundary.get(nums[i]) == null) {
                leftBoundary.put(nums[i], i);
            }

            rightBoundary.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        int degreeArray = Collections.max(count.values());

        for (int element : count.keySet()) {
            if (count.get(element) == degreeArray) {
                result = Math.min(result,
                        rightBoundary.get(element) -
                                leftBoundary.get(element) +
                                1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example 1:
        int[] nums1 = {1,2,2,3,1};
        //  O/P: 2

        // Example 2:
        int[] nums2 = {1,2,2,3,1,4,2};
        //  O/P: 6

        System.out.println(findShortestSubArray(nums1));
        System.out.println(findShortestSubArray(nums2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
