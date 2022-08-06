package com.leetcode.hard.median_of_two_sorted_arrays;

public class Solution {
    //Given two sorted arrays nums1 and nums2 of size m and n respectively, return
    //the median of the two sorted arrays.
    //
    // The overall run time complexity should be O(log (m+n)).
    //
    //
    // Example 1:
    //
    //
    //Input: nums1 = [1,3], nums2 = [2]
    //Output: 2.00000
    //Explanation: merged array = [1,2,3] and median is 2.
    //
    //
    // Example 2:
    //
    //
    //Input: nums1 = [1,2], nums2 = [3,4]
    //Output: 2.50000
    //Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    //
    //
    //
    // Constraints:
    //
    //
    // nums1.length == m
    // nums2.length == n
    // 0 <= m <= 1000
    // 0 <= n <= 1000
    // 1 <= m + n <= 2000
    // -10⁶ <= nums1[i], nums2[i] <= 10⁶
    //
    //
    // Related Topics Array Binary Search Divide and Conquer 👍 18027 👎 2130


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int[] a = nums1;
        int[] b = nums2;

        int aLength = a.length;
        int bLength = b.length;

        // range of a1 cut location: n1 means no right half for a1
        int l = 0, r = aLength;
        while (l <= r) {
            int cut1 = (l + r) / 2; // cut location is counted to right half
            int cut2 = (aLength + bLength + 1) / 2 - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            int r1 = cut1 == aLength ? Integer.MAX_VALUE : a[cut1];
            int r2 = cut2 == bLength ? Integer.MAX_VALUE : b[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if ((aLength + bLength) % 2 == 0) {
                    return ((double) Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return (double) Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                r = cut1 - 1;
            } else {
                l = cut1 + 1;
            }
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        // Example 1:
        int[] numsA1 = {1,3};
        int[] numsA2 = {2};
        //  O/P: 2.00000

        // Example 2:
        int[] numsB1 = {1,2};
        int[] numsB2 = {3,4};
        //  O/P: 2.50000

        System.out.println(findMedianSortedArrays(numsA1, numsA2));
        System.out.println(findMedianSortedArrays(numsB1, numsB2));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

