package com.leetcode.medium.insert_interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //You are given an array of non-overlapping intervals intervals where intervals[
    //i] = [starti, endi] represent the start and the end of the iᵗʰ interval and
    //intervals is sorted in ascending order by starti. You are also given an interval
    //newInterval = [start, end] that represents the start and end of another interval.
    //
    // Insert newInterval into intervals such that intervals is still sorted in
    //ascending order by starti and intervals still does not have any overlapping
    //intervals (merge overlapping intervals if necessary).
    //
    // Return intervals after the insertion.
    //
    //
    // Example 1:
    //
    //
    //Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    //Output: [[1,5],[6,9]]
    //
    //
    // Example 2:
    //
    //
    //Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    //Output: [[1,2],[3,10],[12,16]]
    //Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
    //
    //
    //
    // Constraints:
    //
    //
    // 0 <= intervals.length <= 10⁴
    // intervals[i].length == 2
    // 0 <= starti <= endi <= 10⁵
    // intervals is sorted by starti in ascending order.
    // newInterval.length == 2
    // 0 <= start <= end <= 10⁵
    //
    //
    // Related Topics Array 👍 5718 👎 387

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        LinkedList<int[]> mergedIntervals = new LinkedList<>();

        int[][] emptyIntervals = {{}};

        //  Check if given intervals is null or empty
        //  If true, return only list of intervals with newInterval
        if (intervals == null || Arrays.deepEquals(intervals, emptyIntervals)) {
            mergedIntervals.add(newInterval);
            return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
        }

        int newIntervalStart = newInterval[0];
        int newIntervalEnd = newInterval[1];

        int index = 0;

        //  Added all intervals with start of the intervals
        //      less than the end of the new interval
        while (index < intervals.length &&
                intervals[index][1] < newIntervalStart) {
            mergedIntervals.add(intervals[index++]);
        }

        int[] interval = new int[2];

        while (index < intervals.length &&
                intervals[index][0] <= newIntervalEnd) {
            newIntervalStart = Math.min(intervals[index][0], newIntervalStart);
            newIntervalEnd = Math.max(intervals[index][1], newIntervalEnd);
            index++;
        }

        interval[0] = newIntervalStart;
        interval[1] = newIntervalEnd;

        mergedIntervals.add(interval);

        //  Add all remaining intervals to the output list
        while (index < intervals.length) {
            mergedIntervals.add(intervals[index++]);
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);

    }

    public static void main (String[] args) {
        // Example 1:
        int[][] intervals1 = {{1,3},{6,9}};
        int[] newInterval1 = {2,5};
        //Output: [[1,5],[6,9]]

        // Example 2:
        int[][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval2 = {4,8};
        //Output: [[1,2],[3,10],[12,16]]

        // Example 3:
        int[][] intervals3 = null;
        int[] newInterval3 = {4,8};

        // Example 4:
        int[][] intervals4 = {{}};
        int[] newInterval4 = {4,8};

        System.out.println(Arrays.deepToString(insert(intervals1, newInterval1)));
        System.out.println(Arrays.deepToString(insert(intervals2, newInterval2)));
        System.out.println(Arrays.deepToString(insert(intervals3, newInterval3)));
        System.out.println(Arrays.deepToString(insert(intervals4, newInterval4)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

