package com.leetcode.easy.first_bad_version;

//  To make it work outside the LeetCode environment:
//  Requires the CORRECT implementation of VersionControl class
//      with boolean isBadVersion(int version) method/API

//  INCORRECT Implementation
//      so that my IDE doesn't yell at me!!!
class VersionControl {
    static boolean isBadVersion (int n) {
        return true;
    }
}

//public class Solution {
public class Solution extends VersionControl {

    //You are a product manager and currently leading a team to develop a new
    //product. Unfortunately, the latest version of your product fails the quality check.
    //Since each version is developed based on the previous version, all the versions
    //after a bad version are also bad.
    //
    // Suppose you have n versions [1, 2, ..., n] and you want to find out the
    //first bad one, which causes all the following ones to be bad.
    //
    // You are given an API bool isBadVersion(version) which returns whether
    //version is bad. Implement a function to find the first bad version. You should
    //minimize the number of calls to the API.
    //
    //
    // Example 1:
    //
    //
    //Input: n = 5, bad = 4
    //Output: 4
    //Explanation:
    //call isBadVersion(3) -> false
    //call isBadVersion(5) -> true
    //call isBadVersion(4) -> true
    //Then 4 is the first bad version.
    //
    //
    // Example 2:
    //
    //
    //Input: n = 1, bad = 1
    //Output: 1
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= bad <= n <= 2³¹ - 1
    //
    //
    // Related Topics Binary Search Interactive 👍 5771 👎 2173


//leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

//public class Solution extends VersionControl {
    static int firstBadVersion(int n) {

        int leftIndex = 1;
        int rightIndex = n;

        while (leftIndex <= rightIndex) {

            int pivotIndex = leftIndex + (rightIndex - leftIndex) / 2;

            //  Not bad version
            if (!isBadVersion (pivotIndex)) {
                //  First bad version should be
                //      on the right side of the pivotIndex
                leftIndex = pivotIndex + 1;
            //  Bad version
            } else {
                //  First bad version should be
                //      on the left side of the pivotIndex
                //  Meaning, pivotIndex < current pivotIndex
                rightIndex = pivotIndex - 1;
            }
        }
        return leftIndex;
    }

    public static void main(String[] args) {
        // Example 1:
        int n1 = 5;
        int bad1 = 4;
        //  O/P: 4

        // Example 2:
        int n2 = 1;
        int bad2 = 1;
        //  O/P: 1

        System.out.println(firstBadVersion(n1));
        System.out.println(firstBadVersion(n2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
