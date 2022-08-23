package com.leetcode.medium.permutations;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    //Given an array nums of distinct integers, return all the possible
    //permutations. You can return the answer in any order.
    //
    //
    // Example 1:
    // Input: nums = [1,2,3]
    //Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    //
    // Example 2:
    // Input: nums = [0,1]
    //Output: [[0,1],[1,0]]
    //
    // Example 3:
    // Input: nums = [1]
    //Output: [[1]]
    //
    //
    // Constraints:
    //
    //
    // 1 <= nums.length <= 6
    // -10 <= nums[i] <= 10
    // All the integers of nums are unique.
    //
    //
    // Related Topics Array Backtracking 👍 12438 👎 214


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static List<List<Integer>> permute(int[] nums) {

        int leftIndex = 0;
        int matchedIndex = 0;

        List<Integer> matchedList = new ArrayList<>();
        List <List<Integer>> resultLists = new ArrayList<>();
                //  Output list of lists to be returned
        List<List<Integer>> outputPermutations = new ArrayList<>();

        //  Queue to create a list of all permutations
        Deque<List<Integer>> allPermutations = new ArrayDeque<>();

        //  Add (to the list of all permutations) an empty list first
        allPermutations.add(new ArrayList<>());

        for (int currentElement : nums) {

            int sizeAllPermutations = allPermutations.size();

            for (int i = 0; i < sizeAllPermutations; i++){
                //  Remove and store that last (old) permutation
                List<Integer> oldPermutation = allPermutations.poll();

                //  Create new permutation
                //  Add the currentElement at every index
                for (int j = 0; j <= oldPermutation.size(); j++) {

                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(j, currentElement);

                    if (newPermutation.size() == nums.length) {
                       outputPermutations.add(newPermutation);
                    } else {
                        allPermutations.add(newPermutation);
                    }

                }

            }

        }

        return outputPermutations;

    }

    public static void main(String[] args) {

        // Example 1:
        int[] nums1 = {1,2,3};
        //  O/P: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        // Example 2:
        int[] nums2 = {0,1};
        //  O/P: [[0,1],[1,0]]

        // Example 3:
        int[] nums3 = {1};
        //  O/P: [[1]]

        System.out.println(permute(nums1));
        System.out.println(permute(nums2));
        System.out.println(permute(nums3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)