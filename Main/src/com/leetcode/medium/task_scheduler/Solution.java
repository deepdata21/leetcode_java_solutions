package com.leetcode.medium.task_scheduler;

public class Solution {
    //Given a characters array tasks, representing the tasks a CPU needs to do,
    //where each letter represents a different task. Tasks could be done in any order.
    //Each task is done in one unit of time. For each unit of time, the CPU could
    //complete either one task or just be idle.
    //
    // However, there is a non-negative integer n that represents the cooldown
    //period between two same tasks (the same letter in the array), that is that there
    //must be at least n units of time between any two same tasks.
    //
    // Return the least number of units of times that the CPU will take to finish
    //all the given tasks.
    //
    //
    // Example 1:
    //
    //
    //Input: tasks = ["A","A","A","B","B","B"], n = 2
    //Output: 8
    //Explanation:
    //A -> B -> idle -> A -> B -> idle -> A -> B
    //There is at least 2 units of time between any two same tasks.
    //
    //
    // Example 2:
    //
    //
    //Input: tasks = ["A","A","A","B","B","B"], n = 0
    //Output: 6
    //Explanation: On this case any permutation of size 6 would work since n = 0.
    //["A","A","A","B","B","B"]
    //["A","B","A","B","A","B"]
    //["B","B","B","A","A","A"]
    //...
    //And so on.
    //
    //
    // Example 3:
    //
    //
    //Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
    //Output: 16
    //Explanation:
    //One possible solution is
    //A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle ->
    // idle -> A
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= task.length <= 10⁴
    // tasks[i] is upper-case English letter.
    // The integer n is in the range [0, 100].
    //
    //
    // Related Topics Array Hash Table Greedy Sorting Heap (Priority Queue)
    //Counting 👍 7359 👎 1445


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int leastInterval(char[] tasks, int n) {
        //  There are two ways we need to consider
        //      to find the least number of units times
        //      that CPU will take to finish all the given tasks

        //  Way 1:  # of most repeating type(s) of task is NOT
        //          frequent enough to require idle CPU cycle.
        //          In this case length of tasks array gives the
        //          answer (required least number of unit times)

        //  Way 2:  # of most repeating type(s) of task IS
        //          frequent enough to require idle CPU cycle.
        //          In this case, the answer (required least number of unit times)
        //          is obtained using the following expression
        //          (1 + n) * (freqMax - 1) + numOfTasksWithFreqMax
        //          where n = cooldown period between two tasks of same type
        //                    given n units of time
        //          It works because 1 + n gives the time for each task
        //          (w/ max frequency) plus the cooling period
        //          So, 1 + n needs to be mulitplied by the (max frequency - 1)
        //          Then, we will need add all tasks that have max frequency
        //          Henc, 1 was subtracted from max frequency in the earlier calculation

        //  So, maximum of Way 1 and Way 2 is the required answer
        //  Because, idle CPU times should add to the length of tasks array
        //      if there aren't enough tasks to fill the idle CPU cycles

        //  Way 1
        int tasksLength = tasks.length;

        //  Way 2

        //  Declare the array with frequencies
        //  Intialize with 26 elements with default values of 0s
        //      for 26 uppercase English letters
        int[] frequenciesArray = new int[26];

        //  Build the array with frequencies
        for (char task : tasks) {
            //  Subtracting character 'A' from given
            //  task/character makes it 0-indexed
            //  Given, all tasks are given in uppercase letters
            frequenciesArray[task - 'A']++;
        }

        //  Find the maximum frequency from the array w/ frequencies
        //  Declare and initialize the maximum frequency
        int maxFrequency = 0;

        for (int frequency : frequenciesArray) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        //  Count the number of task(s) w/ maxFrequency
        //  Declare and initialize the numMaxFrequencyTasks
        int  numMaxFrequencyTasks = 0;

        for (int frequency : frequenciesArray) {
            if (frequency == maxFrequency) {
                numMaxFrequencyTasks++;
            }
        }

        return Math.max(tasksLength,
                ((1 + n) * (maxFrequency - 1) + numMaxFrequencyTasks));
    }

    public static void main(String[] args) {
        // Example 1:
        char[] tasks1 = {'A','A','A','B','B','B'};
        int n1 = 2;
        //  O/P: 8

        // Example 2:
        char[] tasks2 = {'A','A','A','B','B','B'};
        int n2 = 0;
        //  O/P: 6

        // Example 3:
        char[] tasks3 = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n3 = 2;
        //  O/P: 16

        System.out.println(leastInterval(tasks1, n1));
        System.out.println(leastInterval(tasks2, n2));
        System.out.println(leastInterval(tasks3, n3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

