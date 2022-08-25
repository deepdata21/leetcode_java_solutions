package com.leetcode.medium.design_hit_counter;

//  REQUIRES Java 8

import java.util.Deque;
import java.util.ArrayDeque;
import javafx.util.Pair; // Pair class REQUIRES Java 8

public class Solution {
    //Design a hit counter which counts the number of hits received in the past 5
    //minutes (i.e., the past 300 seconds).
    //
    // Your system should accept a timestamp parameter (in seconds granularity),
    //and you may assume that calls are being made to the system in chronological order (
    //i.e., timestamp is monotonically increasing). Several hits may arrive roughly
    //at the same time.
    //
    // Implement the HitCounter class:
    //
    //
    // HitCounter() Initializes the object of the hit counter system.
    // void hit(int timestamp) Records a hit that happened at timestamp (in seconds)
    //. Several hits may happen at the same timestamp.
    // int getHits(int timestamp) Returns the number of hits in the past 5 minutes
    //from timestamp (i.e., the past 300 seconds).
    //
    //
    //
    // Example 1:
    //
    //
    //Input
    //["HitCounter", "hit", "hit", "hit", "getHits", "hit", "getHits", "getHits"]
    //[[], [1], [2], [3], [4], [300], [300], [301]]
    //Output
    //[null, null, null, null, 3, null, 4, 3]
    //
    //Explanation
    //HitCounter hitCounter = new HitCounter();
    //hitCounter.hit(1);       // hit at timestamp 1.
    //hitCounter.hit(2);       // hit at timestamp 2.
    //hitCounter.hit(3);       // hit at timestamp 3.
    //hitCounter.getHits(4);   // get hits at timestamp 4, return 3.
    //hitCounter.hit(300);     // hit at timestamp 300.
    //hitCounter.getHits(300); // get hits at timestamp 300, return 4.
    //hitCounter.getHits(301); // get hits at timestamp 301, return 3.
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= timestamp <= 2 * 10⁹
    // All the calls are being made to the system in chronological order (i.e.,
    //timestamp is monotonically increasing).
    // At most 300 calls will be made to hit and getHits.
    //
    //
    //
    // Follow up: What if the number of hits per second could be huge? Does your
    //design scale?
    //
    // Related Topics Array Hash Table Binary Search Design Queue 👍 1615 👎 153


    //leetcode submit region begin(Prohibit modification and deletion)
    static class HitCounter {

        //  Declaring variable/data structure
        private int totalTimeStamps;
        private Deque<Pair<Integer, Integer>> hitsQueue;

        //  Initialization
        public HitCounter() {
            this.totalTimeStamps = 0;
            this.hitsQueue = new ArrayDeque<Pair<Integer, Integer>>();
        }

        public void hit(int timestamp) {
            //  timestamp is in the key of the Pair
            //  If queue is empty or
            //      there is no element with current timestamp in the queue
            if (this.hitsQueue.isEmpty() ||
                this.hitsQueue.getLast().getKey() != timestamp) {
                this.hitsQueue.offer(new Pair<Integer, Integer>(timestamp, 1));
            } else {
                int previousCount = this.hitsQueue.getLast().getValue();
                //  Remove the last element so that
                //      an element with the same timestamp can be added
                //      with updated hit counts
                this.hitsQueue.pollLast();
                //
                this.hitsQueue.offer(new Pair<Integer, Integer>(timestamp, previousCount + 1));
            }
            //  Increase the count of timestamps by one
            this.totalTimeStamps++;
        }

        public int getHits(int timestamp) {
            while (!this.hitsQueue.isEmpty()) {
                int timeDifference =
                        timestamp - this.hitsQueue.getFirst().getKey();
                if (timeDifference >= 300) {
                    //  Decrease the count of timestamps by one
                    this.totalTimeStamps -= this.hitsQueue.getFirst().getValue();
                    //  And, remove the element with first timestamp
                    this.hitsQueue.pollFirst();
                }
                else break;
            }

            return this.totalTimeStamps;

        }

    }

    public static void main(String[] args) {
        // Example 1:
        //Input
        //["HitCounter", "hit", "hit", "hit", "getHits", "hit", "getHits", "getHits"]
        //[[], [1], [2], [3], [4], [300], [300], [301]]
        //Output
        //[null, null, null, null, 3, null, 4, 3]

        HitCounter hitCounter = new HitCounter();

        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);

//        hitCounter.getHits(4);
        System.out.println(hitCounter.getHits(4));

        hitCounter.hit(300);

//        hitCounter.getHits(300);
        System.out.println(hitCounter.getHits(300));

//        hitCounter.getHits(301);
        System.out.println(hitCounter.getHits(301));

    }

}
/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)
