package com.leetcode.medium.merge_intervals;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    //Given an array of intervals where intervals[i] = [starti, endi], merge all
    //overlapping intervals, and return an array of the non-overlapping intervals that
    //cover all the intervals in the input.
    //
    //
    // Example 1:
    //
    //
    //Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    //Output: [[1,6],[8,10],[15,18]]
    //Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
    //
    //
    // Example 2:
    //
    //
    //Input: intervals = [[1,4],[4,5]]
    //Output: [[1,5]]
    //Explanation: Intervals [1,4] and [4,5] are considered overlapping.
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= intervals.length <= 10⁴
    // intervals[i].length == 2
    // 0 <= starti <= endi <= 10⁴
    //
    //
    // Related Topics Array Sorting 👍 15438 👎 558


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int[][] merge(int[][] intervals) {

        //  Sort the given array based on the
        //      starting value of each interval
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        //  Create a new LinkedList to generate the output
        LinkedList<int[]> mergedList = new LinkedList<>();

        for (int[] interval : intervals) {
            if (mergedList.isEmpty() ||
                    //  Or, if the ending value of last interval is less
                    //      than the starting value of the current interval
                    mergedList.getLast()[1] < interval [0]) {
                mergedList.add(interval);
            } else {
                //  Update the ending value of the last interval
                mergedList.getLast()[1] =
                        //  The maximum of:
                        //      the ending value of the last interval and
                        //      the ending value of the current interval
                        Math.max(mergedList.getLast()[1], interval[1]);
            }
        }

        return mergedList.toArray(new int[mergedList.size()][]);
    }

    public static void main(String[] args) {

        // Example 1:
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        //  O/P: [[1,6],[8,10],[15,18]]

        // Example 2:
        int[][] intervals2 = {{1,4},{4,5}};
        //  O/P: [[1,5]]

        System.out.println(Arrays.deepToString(merge(intervals1)));
        System.out.println(Arrays.deepToString(merge(intervals2)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
