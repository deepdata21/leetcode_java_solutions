package com.leetcode.hard.find_median_from_data_stream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
//The median is the middle value in an ordered integer list. If the size of the
//list is even, there is no middle value and the median is the mean of the two
//middle values.
//
//
// For example, for arr = [2,3,4], the median is 3.
// For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
//
//
// Implement the MedianFinder class:
//
//
// MedianFinder() initializes the MedianFinder object.
// void addNum(int num) adds the integer num from the data stream to the data
//structure.
// double findMedian() returns the median of all elements so far. Answers
//within 10⁻⁵ of the actual answer will be accepted.
//
//
//
// Example 1:
//
//
//Input
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//Output
//[null, null, null, 1.5, null, 2.0]
//
//Explanation
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0
//
//
//
// Constraints:
//
//
// -10⁵ <= num <= 10⁵
// There will be at least one element in the data structure before calling
//findMedian.
// At most 5 * 10⁴ calls will be made to addNum and findMedian.
//
//
//
// Follow up:
//
//
// If all integer numbers from the stream are in the range [0, 100], how would
//you optimize your solution?
// If 99% of all integer numbers from the stream are in the range [0, 100], how
//would you optimize your solution?
//
//
// Related Topics Two Pointers Design Sorting Heap (Priority Queue) Data Stream
//👍 7665 👎 138


//leetcode submit region begin(Prohibit modification and deletion)
//class MedianFinder {

    //  maxHeap for upper half (w/ lower value) of the stream
    //      for example,
    //      9 8 7 6 5 4
    PriorityQueue<Integer> maxHeap = null;

    //  minHeap for lower half (w/ lower value) of the stream
    //      for example,
    //      10 11 12 13 14 15
    PriorityQueue<Integer> minHeap = null;

    //  Initialize the data structures
    public Solution () {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {

        // Example 1:
        //Input
        //["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
        //[[], [1], [2], [], [3], []]
        //Output
        //[null, null, null, 1.5, null, 2.0]

        //  Solution instead of MedianFinder since Solution is class name
        Solution medianFinder = new Solution();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
        System.out.println(medianFinder.findMedian());

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

