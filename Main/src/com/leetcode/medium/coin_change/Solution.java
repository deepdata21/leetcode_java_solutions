package com.leetcode.medium.coin_change;

import java.util.Arrays;

public class Solution {
    //You are given an integer array coins representing coins of different
    //denominations and an integer amount representing a total amount of money.
    //
    // Return the fewest number of coins that you need to make up that amount. If
    //that amount of money cannot be made up by any combination of the coins, return -1.
    //
    //
    // You may assume that you have an infinite number of each kind of coin.
    //
    //
    // Example 1:
    //
    //
    //Input: coins = [1,2,5], amount = 11
    //Output: 3
    //Explanation: 11 = 5 + 5 + 1
    //
    //
    // Example 2:
    //
    //
    //Input: coins = [2], amount = 3
    //Output: -1
    //
    //
    // Example 3:
    //
    //
    //Input: coins = [1], amount = 0
    //Output: 0
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= coins.length <= 12
    // 1 <= coins[i] <= 2³¹ - 1
    // 0 <= amount <= 10⁴
    //
    //
    // Related Topics Array Dynamic Programming Breadth-First Search 👍 13111 👎 293
    //

    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
        static int coinChange(int[] coins, int amount) {

            //  Approach: Dynamic Programming - Bottom Up
            //  Iterative Solution

            //  Because going from 0 to amount
            int max = amount + 1;
            int[] dp = new int[max];
            Arrays.fill(dp, max);
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }

    public static void main(String[] args) {
        // Example 1:
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        //  O/P: 3

        // Example 2:
        int[] coins2 = {2};
        int amount2 = 3;
        //  O/P: -1

        // Example 3:
        int[] coins3 = {1};
        int amount3 = 0;
        //  O/P: 0

        System.out.println(coinChange(coins1, amount1));
        System.out.println(coinChange(coins2, amount2));
        System.out.println(coinChange(coins3, amount3));

    }

}
//leetcode submit region end(Prohibit modification and deletion)

