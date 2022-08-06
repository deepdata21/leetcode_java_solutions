package com.leetcode.easy.minimum_cost_climbing_stairs;

public class Solution {
    //You are given an integer array cost where cost[i] is the cost of iᵗʰ step on
    //a staircase. Once you pay the cost, you can either climb one or two steps.
    //
    // You can either start from the step with index 0, or the step with index 1.
    //
    // Return the minimum cost to reach the top of the floor.
    //
    //
    // Example 1:
    //
    //
    //Input: cost = [10,15,20]
    //Output: 15
    //Explanation: You will start at index 1.
    //- Pay 15 and climb two steps to reach the top.
    //The total cost is 15.
    //
    //
    // Example 2:
    //
    //
    //Input: cost = [1,100,1,1,1,100,1,1,100,1]
    //Output: 6
    //Explanation: You will start at index 0.
    //- Pay 1 and climb two steps to reach index 2.
    //- Pay 1 and climb two steps to reach index 4.
    //- Pay 1 and climb two steps to reach index 6.
    //- Pay 1 and climb one step to reach index 7.
    //- Pay 1 and climb two steps to reach index 9.
    //- Pay 1 and climb one step to reach the top.
    //The total cost is 6.
    //
    //
    //
    // Constraints:
    //
    //
    // 2 <= cost.length <= 1000
    // 0 <= cost[i] <= 999
    //
    //
    // Related Topics Array Dynamic Programming 👍 7328 👎 1187


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int minCostClimbingStairs(int[] cost) {

        int dp1 = 0;
        int dp2 = 0;

        for (int i = 0; i < cost.length; i++) {
            int dp0 = cost[i] + java.lang.Math.min(dp1, dp2);

            dp2 = dp1;
            dp1 = dp0;
        }
        return java.lang.Math.min(dp1, dp2);
    }

    public static void main(String[] args) {

        int[] cost1 = {};

        // Example 1:
        int[] cost2 = {10,15,20};
        //  O/P: 15

        // Example 2:
        int[] cost3 = {1,100,1,1,1,100,1,1,100,1};
        //  O/P: 6

        int[] cost4 = {503};

        System.out.println(minCostClimbingStairs(cost1));
        System.out.println(minCostClimbingStairs(cost2));
        System.out.println(minCostClimbingStairs(cost3));
        System.out.println(minCostClimbingStairs(cost4));
    }

}
//leetcode submit region end(Prohibit modification and deletion)

