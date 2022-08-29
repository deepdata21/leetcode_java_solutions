package com.leetcode.medium.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //Given an array of distinct integers candidates and a target integer target,
    //return a list of all unique combinations of candidates where the chosen numbers
    //sum to target. You may return the combinations in any order.
    //
    // The same number may be chosen from candidates an unlimited number of times.
    //Two combinations are unique if the frequency of at least one of the chosen
    //numbers is different.
    //
    // It is guaranteed that the number of unique combinations that sum up to
    //target is less than 150 combinations for the given input.
    //
    //
    // Example 1:
    //
    //
    //Input: candidates = [2,3,6,7], target = 7
    //Output: [[2,2,3],[7]]
    //Explanation:
    //2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
    //times.
    //7 is a candidate, and 7 = 7.
    //These are the only two combinations.
    //
    //
    // Example 2:
    //
    //
    //Input: candidates = [2,3,5], target = 8
    //Output: [[2,2,2,2],[2,3,3],[3,5]]
    //
    //
    // Example 3:
    //
    //
    //Input: candidates = [2], target = 1
    //Output: []
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= candidates.length <= 30
    // 1 <= candidates[i] <= 200
    // All elements of candidates are distinct.
    // 1 <= target <= 500
    //
    //
    // Related Topics Array Backtracking 👍 13015 👎 268


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {

    private static void backtrackingMethod(
            int remainingTarget,
            LinkedList<Integer> currentCombination,
            int startIndex,
            int[] candidates,
            List<List<Integer>> outputList
    ) {

        if (remainingTarget == 0) {
            //  Make a deep copy the currentCombination
            //      and add it to the output list of lists
            outputList.add(new ArrayList<>(currentCombination));
            return;
        } else if (remainingTarget < 0) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            currentCombination.add(candidates[i]);
            backtrackingMethod(remainingTarget - candidates[i],
                    currentCombination,
                    i,
                    candidates,
                    outputList);

            currentCombination.removeLast();

        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> outputList = new ArrayList<>();
        LinkedList<Integer> currentCombination = new LinkedList<>();

        backtrackingMethod(target,
                currentCombination,
                0,
                candidates,
                outputList);

        return outputList;

    }

    public static void main(String[] args) {
        // Example 1:
        int[] candidates1 = {2,3,6,7};
        int target1 = 7;
        //  O/P: [[2,2,3],[7]]

        // Example 2:
        int[] candidates2 = {2,3,5};
        int target2 = 8;
        //Output: [[2,2,2,2],[2,3,3],[3,5]]

        // Example 3:
        int[] candidates3 = {2};
        int target3 = 1;
        //Output: []

        System.out.println(combinationSum(candidates1, target1));
        System.out.println(combinationSum(candidates2, target2));
        System.out.println(combinationSum(candidates3, target3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
