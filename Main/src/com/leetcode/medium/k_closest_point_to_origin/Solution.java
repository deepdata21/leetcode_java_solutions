package com.leetcode.medium.k_closest_point_to_origin;

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Solution {
    //Given an array of points where points[i] = [xi, yi] represents a point on the
    //X-Y plane and an integer k, return the k closest points to the origin (0, 0).
    //
    // The distance between two points on the X-Y plane is the Euclidean distance (
    //i.e., √(x1 - x2)² + (y1 - y2)²).
    //
    // You may return the answer in any order. The answer is guaranteed to be
    //unique (except for the order that it is in).
    //
    //
    // Example 1:
    //
    //
    //Input: points = [[1,3],[-2,2]], k = 1
    //Output: [[-2,2]]
    //Explanation:
    //The distance between (1, 3) and the origin is sqrt(10).
    //The distance between (-2, 2) and the origin is sqrt(8).
    //Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
    //We only want the closest k = 1 points from the origin, so the answer is just [
    //[-2,2]].
    //
    //
    // Example 2:
    //
    //
    //Input: points = [[3,3],[5,-1],[-2,4]], k = 2
    //Output: [[3,3],[-2,4]]
    //Explanation: The answer [[-2,4],[3,3]] would also be accepted.
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= k <= points.length <= 10⁴
    // -10⁴ < xi, yi < 10⁴
    //
    //
    // Related Topics Array Math Divide and Conquer Geometry Sorting Heap (Priority
    //Queue) Quickselect 👍 6532 👎 237

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {

    public static int[][] kClosest(int[][] points, int k) {

        //  Declare the output 2D array
        //  1st []: k number of rows
        //  2nd []: 2 colums
        int[][] result2DArray = new int[k][2];

        //  Declare maximum Heap with PriorityQueue Class
        //      using (x2 * x2) + (y2 * y2) - (x1 * x1) - (y1 * y1)
        //      instead of using
        //      sqrt((x2 * x2) + (y2 * y2)) - sqrt(((x1 * x1) + (y1 * y1))
        //      to compare the distances from origin
        Queue<int[]> maxHeap = new PriorityQueue<>((p1, p2) ->
                (p2[0] * p2[0]) + (p2[1] * p2[1])
                - (p1[0] * p1[0]) - (p1[1] * p1[1]));

        //  Add all points (as int arrays) to maxHeap
        //  Poll to remove all points if maxHeap has more
        //      than k points (of type int[]),
        //      which automatically removes points
        //      larger (hence maximum heap) distances
        //      from the heap data structure
        //   Since, maxHeap has maximum values on top
        for (int [] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        //  Poll to save points in already defined
        //      result2DArray
        //  --k is precrement:
        //      it first decreases the k by 1 and then
        //      applies the decreased value as result2DArray index
        //      to store polled array at the decreased index
        //  k > 0: means the very last k = 1;
        //      so, the very last --k = 0;
        //      therefore, result2DArray fills from the end index
        //      to the start index
        while (k > 0) {
            result2DArray[--k] = maxHeap.poll();
        }

        return result2DArray;
    }

    public static void main(String[] args) {
        // Example 1:
        int[][] points1 = {{1,3},{-2,2}};
        int k1 = 1;
        //  O/P: [[-2,2]]

        // Example 2:
        int[][] points2 = {{3,3},{5,-1},{-2,4}};
        int k2 = 2;
        //  O/P: [[3,3],[-2,4]]

        System.out.println(Arrays.deepToString(kClosest(points1, k1)));
        System.out.println(Arrays.deepToString(kClosest(points2, k2)));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

