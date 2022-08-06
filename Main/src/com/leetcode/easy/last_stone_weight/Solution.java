package com.leetcode.easy.last_stone_weight;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    //You are given an array of integers stones where stones[i] is the weight of
    //the iᵗʰ stone.
    //
    // We are playing a game with the stones. On each turn, we choose the heaviest
    //two stones and smash them together. Suppose the heaviest two stones have weights
    //x and y with x <= y. The result of this smash is:
    //
    //
    // If x == y, both stones are destroyed, and
    // If x != y, the stone of weight x is destroyed, and the stone of weight y has
    //new weight y - x.
    //
    //
    // At the end of the game, there is at most one stone left.
    //
    // Return the weight of the last remaining stone. If there are no stones left,
    //return 0.
    //
    //
    // Example 1:
    //
    //
    //Input: stones = [2,7,4,1,8,1]
    //Output: 1
    //Explanation:
    //We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
    //we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
    //we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
    //we combine 1 and 1 to get 0 so the array converts to [1] then that's the
    //value of the last stone.
    //
    //
    // Example 2:
    //
    //
    //Input: stones = [1]
    //Output: 1
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= stones.length <= 30
    // 1 <= stones[i] <= 1000
    //
    //
    // Related Topics Array Heap (Priority Queue) 👍 3439 👎 69

    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int lastStoneWeight(int[] stones) {

        //  Insert all the stones into maximum heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                Comparator.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        //  While there is more than one stone left, ...
        //      we need to remove the two largest and ...
        //      smash them together. If there is a resulting ...
        //      stone, we need to put it into the heap.

        while (maxHeap.size() > 1) {
            int firstLargestStone = maxHeap.remove();
            int secondLargestStone = maxHeap.remove();

            if (firstLargestStone != secondLargestStone) {
                maxHeap.add(firstLargestStone - secondLargestStone);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.remove();
    }

    public static void main(String[] args) {

        // Example 1:
        int[] stones1 = {2,7,4,1,8,1};
        //  O/P: 1

        // Example 2:
        int[] stones2 = {1};
        //  O/P: 1

        // Example 2:
        int[] stones3 = {};
        //  O/P: 0

        System.out.println(lastStoneWeight(stones1));
        System.out.println(lastStoneWeight(stones2));
        System.out.println(lastStoneWeight(stones3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

