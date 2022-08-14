package com.leetcode.easy.count_odd_nums_in_interval_range;

public class Solution {
    //Given two non-negative integers low and high. Return the count of odd numbers
    //between low and high (inclusive).
    //
    //
    // Example 1:
    //
    //
    //Input: low = 3, high = 7
    //Output: 3
    //Explanation: The odd numbers between 3 and 7 are [3,5,7].
    //
    // Example 2:
    //
    //
    //Input: low = 8, high = 10
    //Output: 1
    //Explanation: The odd numbers between 8 and 10 are [9].
    //
    //
    // Constraints:
    //
    //
    // 0 <= low <= high <= 10^9
    //
    //
    // Related Topics Math 👍 937 👎 70


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int countOdds(int low, int high) {

        //  The count of odd integers between 1 and n (inclusive):
        //      n + 1 / 2

        //  (high + 1) / 2: gives total number of odd integers
        //      between 1 and high (both inclusive)
        //  low / 2: gives total number of odd integers
        //      between 1 and low - 1 (both inclusive)
        //  So, the count of odd integers between high (an integer)
        //      and low (an integer)---both inclusive:
        //      (high + 1) / 2 - low / 2
        return (high + 1) / 2 - low / 2;
    }

    public static void main(String[] args) {
        // Example 1:
        int low1 = 3;
        int high1 = 7;
        //  O/P: 3

        // Example 2:
        int low2 = 8;
        int high2 = 10;
        //  O/P: 1

        System.out.println(countOdds(low1, high1));
        System.out.println(countOdds(low2, high2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
