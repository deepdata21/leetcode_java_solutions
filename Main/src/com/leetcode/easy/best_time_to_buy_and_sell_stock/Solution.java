package com.leetcode.easy.best_time_to_buy_and_sell_stock;

public class Solution {

//You are given an array prices where prices[i] is the price of a given stock
//on the iᵗʰ day.
//
// You want to maximize your profit by choosing a single day to buy one stock
//and choosing a different day in the future to sell that stock.
//
// Return the maximum profit you can achieve from this transaction. If you
//cannot achieve any profit, return 0.
//
//
// Example 1:
//
//
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
//6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you
//must buy before you sell.
//
//
// Example 2:
//
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
//
//
//
// Constraints:
//
//
// 1 <= prices.length <= 10⁵
// 0 <= prices[i] <= 10⁴
//
// Related Topics Array Dynamic Programming 👍 17249 👎 564


////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int maxProfit(int[] prices) {

//        int profit = 0;
//        int maxProfit = 0;
//
//
//        for (int i = 0; i < prices.length - 1; i++) {
//
//            for (int j = i + 1; j < prices.length; j++) {
//                profit = prices[j] - prices[i];
////                maxProfit = Math.max(profit, maxProfit);
//                if (profit > maxProfit) {
//                    maxProfit = profit;
//                }
//            }
//        }
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else if (prices[i] - minValue > maxProfit) {
                maxProfit = prices[i] - minValue;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        //  O/P: 5

        int[] prices2 = {7,6,4,3,1};
        //  O/P: 0

        System.out.println("Ex1: " + maxProfit(prices1));
        System.out.println("Ex2: " + maxProfit(prices2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
