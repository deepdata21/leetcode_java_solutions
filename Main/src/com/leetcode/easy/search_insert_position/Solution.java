package com.leetcode.easy.search_insert_position;

public class Solution {

//Given a sorted array of distinct integers and a target value, return the
//index if the target is found. If not, return the index where it would be if it were
//inserted in order.
//
// You must write an algorithm with O(log n) runtime complexity.
//
// Example 1:
//
//Input: nums = [1,3,5,6], target = 5
//Output: 2
//
// Example 2:
//
//Input: nums = [1,3,5,6], target = 2
//Output: 1
//
// Example 3:
//
//Input: nums = [1,3,5,6], target = 7
//Output: 4
//
// Constraints:
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums contains distinct values sorted in ascending order.
// -10⁴ <= target <= 10⁴
//

    //  Given a sorted array of distinct integers and a target value, return the
    //  ...index if the target is found. If not, return the index where it would be if it were
    //  ...inserted in order.

    static int searchinsertposition (int[] arr, int target) {
        int left = 0;
        int right = arr.length -1;

        while(left <= right) {
            int pivot = left + (right - left)/2;
            if (arr[pivot] == target) return pivot;
            if (arr[pivot] > target) {
                right = pivot - 1;
            } else left = pivot + 1;
        }
        return left;
    }

    public static void main(String[] args) {

        //Output: 2
        int[] nums1 = {1,3,5,6};
        int target1 = 5;

        //  Output: 1
        int[] nums2 = {1,3,5,6};
        int target2 = 2;

        //Output: 4
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;

//        searchinsertposition(nums1, target1);
//        searchinsertposition(nums2, target2);
//        searchinsertposition(nums3, target3);
        System.out.println("Example 1 [O/P - 2] : " + searchinsertposition(nums1, target1));
        System.out.println("Example 2 [O/P - 1] : " + searchinsertposition(nums2, target2));
        System.out.println("Example 3 [O/P - 4] : " + searchinsertposition(nums3, target3));

    }

}
