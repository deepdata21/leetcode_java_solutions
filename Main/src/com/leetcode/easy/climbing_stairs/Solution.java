package com.leetcode.easy.climbing_stairs;

public class Solution {

// Each time you can either climb 1 or 2 steps. In how many distinct ways can
//you climb to the top?
//
// Example 1:
//
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//
// Example 2:
//
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step

    static int climbingStairs (int n) {

        if (n == 0 || n == 1) return 1;

        int[] numWays = new int[n + 1];

        numWays[0] = 1;
        numWays[1] = 1;

        for (int i = 2; i <= n; i++) {
            numWays[i] = numWays[i -1] + numWays[i - 2];
        }

        return numWays[n];
    }

    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 3;
        int n3 = 8;

//        climbingStairs(n1);
//        climbingStairs(n2);
//        climbingStairs(n3);

        System.out.println(climbingStairs(n1));
        System.out.println(climbingStairs(n2));
        System.out.println(climbingStairs(n3));
    }

}