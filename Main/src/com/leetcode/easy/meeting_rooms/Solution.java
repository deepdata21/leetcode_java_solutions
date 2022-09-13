package com.leetcode.easy.meeting_rooms;

import java.util.Arrays;

public class Solution {
//Given an array of meeting time intervals where intervals[i] = [starti, endi],
//determine if a person could attend all meetings.
//
//
// Example 1:
// Input: intervals = [[0,30],[5,10],[15,20]]
//Output: false
//
// Example 2:
// Input: intervals = [[7,10],[2,4]]
//Output: true
//
//
// Constraints:
//
//
// 0 <= intervals.length <= 10⁴
// intervals[i].length == 2
// 0 <= starti < endi <= 10⁶
//
//
// Related Topics Array Sorting 👍 1619 👎 78


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static boolean canAttendMeetings(int[][] intervals) {
        //  Sort the given array of intervals
        //      by the start time of each interval
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        //  Loop through the given array, and
        //      compare two adjacent intervals
        //      by checking if the end time of preceding interval
        //      is ends after the start time of next adjacent interval
        //  Return false if the end time of preceding interval
        //      is greater than the start time of next adjacent interval
        for (int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Example 1:
        int[][] intervals1 = {{0,30}, {5,10}, {15,20}};
        //  O/P: false

        // Example 2:
        int[][] intervals2 = {{7,10}, {2,4}};
        //  O/P: true

        // Example 3:
        int[][] intervals3 = {{0,30},{60,240},{90,120}};
        //  O/P: false

        // Example 4:
        int[][] intervals4 = {{7,10}, {2,4}};
        //  O/P: true

        System.out.println(canAttendMeetings(intervals1));
        System.out.println(canAttendMeetings(intervals2));
        System.out.println(canAttendMeetings(intervals3));
        System.out.println(canAttendMeetings(intervals4));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
