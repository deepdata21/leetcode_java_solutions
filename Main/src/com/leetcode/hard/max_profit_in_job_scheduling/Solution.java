package com.leetcode.hard.max_profit_in_job_scheduling;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {
    //We have n jobs, where every job is scheduled to be done from startTime[i] to
    //endTime[i], obtaining a profit of profit[i].
    //
    // You're given the startTime, endTime and profit arrays, return the maximum
    //profit you can take such that there are no two jobs in the subset with overlapping
    //time range.
    //
    // If you choose a job that ends at time X you will be able to start another
    //job that starts at time X.
    //
    //
    // Example 1:
    //
    //
    //
    //
    //Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
    //Output: 120
    //Explanation: The subset chosen is the first and fourth job.
    //Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
    //
    //
    // Example 2:
    //
    //
    //
    //
    //Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70
    //,60]
    //Output: 150
    //Explanation: The subset chosen is the first, fourth and fifth job.
    //Profit obtained 150 = 20 + 70 + 60.
    //
    //
    // Example 3:
    //
    //
    //
    //
    //Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
    //Output: 6
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= startTime.length == endTime.length == profit.length <= 5 * 10⁴
    // 1 <= startTime[i] < endTime[i] <= 10⁹
    // 1 <= profit[i] <= 10⁴
    //
    //
    // Related Topics Array Binary Search Dynamic Programming Sorting 👍 3766 👎 39


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {

    static class ArrayComparator implements Comparator <ArrayList<Integer>> {
        public int compare (ArrayList<Integer> aList1,
                            ArrayList<Integer> aList2) {
            return aList1.get(0) - aList2.get(0);
        }
    }

    private static int findMaxProfit (List<List<Integer>> jobsList) {
        //  Initialize maximum profit
        int maxProfit = 0;

        //  Declare a minimum heap with PriorityQueue
        //      using ArrayComparator to set priority
        //  Each entry will have end time and profit only
        Queue<ArrayList<Integer>> minHeap =
                new PriorityQueue<>(new ArrayComparator());

        for (int i = 0; i < jobsList.size(); i++) {
            int startTime = jobsList.get(i).get(0);
            int endTime = jobsList.get(i).get(1);
            int profit = jobsList.get(i).get(2);

            //  Check until minHeap is not empty
            //      and update the maxProfit
            while (!minHeap.isEmpty() &&
                    startTime >= minHeap.peek().get(0)) {
                maxProfit = Math.max(maxProfit, minHeap.peek().get(1));
                minHeap.poll();
            }

            //  Declare an ArrayList for the updated combined job
            ArrayList<Integer> updatedJob = new ArrayList<>();
            //  Add the current end time
            updatedJob.add(endTime);

            //  Add the updated maximum profit
            updatedJob.add(profit + maxProfit);

            //  Update minHeap
            minHeap.offer(updatedJob);
        }

        while (!minHeap.isEmpty()) {
           maxProfit = Math.max(maxProfit, minHeap.peek().get(1));
           minHeap.poll();
        }

        return maxProfit;
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        List<List<Integer>> jobsList = new ArrayList<>();

        for (int i = 0; i < profit.length; i++) {
            List<Integer> currentJob = new ArrayList<>();

            currentJob.add(startTime[i]);
            currentJob.add(endTime[i]);
            currentJob.add(profit[i]);

            jobsList.add(currentJob);
        }

        //  Sort JobsList by the start time of each job
        jobsList.sort(Comparator.comparingInt(a -> a.get(0)));

        return findMaxProfit(jobsList);
    }

    public static void main(String[] args) {
        // Example 1:
        int[] startTime1 = {1,2,3,3};
        int[] endTime1 = {3,4,5,6};
        int[] profit1 = {50,10,40,70};
        //  O/P: 120

        // Example 2:
        int[] startTime2 = {1,2,3,4,6};
        int[] endTime2 = {3,5,10,6,9};
        int[] profit2 = {20,20,100,70, 60};
        //  O/P: 150

        // Example 3:
        int[] startTime3 = {1,1,1};
        int[] endTime3 = {2,3,4};
        int[] profit3 = {5,6,4};
        //  O/P: 6

        System.out.println(jobScheduling(startTime1, endTime1, profit1));
        System.out.println(jobScheduling(startTime2, endTime2, profit2));
        System.out.println(jobScheduling(startTime3, endTime3, profit3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
