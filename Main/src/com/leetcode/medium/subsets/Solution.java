package com.leetcode.medium.subsets;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    //Given an integer array nums of unique elements, return all possible subsets (
    //the power set).
    //
    // The solution set must not contain duplicate subsets. Return the solution in
    //any order.
    //
    //
    // Example 1:
    //
    //
    //Input: nums = [1,2,3]
    //Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    //
    //
    // Example 2:
    //
    //
    //Input: nums = [0]
    //Output: [[],[0]]
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= nums.length <= 10
    // -10 <= nums[i] <= 10
    // All the numbers of nums are unique.
    //
    //
    // Related Topics Array Backtracking Bit Manipulation 👍 11734 👎 170


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static List<List<Integer>> subsets(int[] nums) {

        //  Using Breadth First Search approach

        //  Declare the ouput set that is the set of all sets
        List<List<Integer>> outputSet = new ArrayList<>();

        //  Add an empty subset to the output list
        outputSet.add(new ArrayList<>());

        for (int currentElement : nums) {

            //  Store the size of the current output set
            int currentSize = outputSet.size();

            //  Add the current element to the existing subsets
            //      in the current output set
            for (int i = 0; i < currentSize; i++) {

                //  Declare the new subset created with current subset
                //      element from the output set
                List<Integer> newSubset =
                        new ArrayList<>(outputSet.get(i));

                //  Add the current element from the given array (nums)
                //      to the new subset
                newSubset.add(currentElement);

                //  Add the new subset to the output list
                outputSet.add(newSubset);

            }

        }

        return outputSet;
    }

    public static void main (String[] args) {
        // Example 1:
        int[] nums1 = {1,2,3};
        //  O/P: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

        // Example 2:
        int[] nums2 = {0};
        //  O/P: [[],[0]]

        System.out.println(subsets(nums1));
        System.out.println(subsets(nums2));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
