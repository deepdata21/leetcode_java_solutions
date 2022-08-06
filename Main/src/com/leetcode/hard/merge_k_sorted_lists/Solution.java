package com.leetcode.hard.merge_k_sorted_lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
//    int data;
    int val;
    ListNode next;

    ListNode (int data) {
//        this.data = data;
        this.val = data;
    }
}

public class Solution {

    //You are given an array of k linked-lists lists, each linked-list is sorted in
    //ascending order.
    //
    // Merge all the linked-lists into one sorted linked-list and return it.
    //
    //
    // Example 1:
    //
    //
    //Input: lists = [[1,4,5],[1,3,4],[2,6]]
    //Output: [1,1,2,3,4,4,5,6]
    //Explanation: The linked-lists are:
    //[
    //  1->4->5,
    //  1->3->4,
    //  2->6
    //]
    //merging them into one sorted list:
    //1->1->2->3->4->4->5->6
    //
    //
    // Example 2:
    //
    //
    //Input: lists = []
    //Output: []
    //
    //
    // Example 3:
    //
    //
    //Input: lists = [[]]
    //Output: []
    //
    //
    //
    // Constraints:
    //
    //
    // k == lists.length
    // 0 <= k <= 10⁴
    // 0 <= lists[i].length <= 500
    // -10⁴ <= lists[i][j] <= 10⁴
    // lists[i] is sorted in ascending order.
    // The sum of lists[i].length will not exceed 10⁴.
    //
    //
    // Related Topics Linked List Divide and Conquer Heap (Priority Queue) Merge
    //Sort 👍 13168 👎 503


    //leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//class Solution {
//     static ListNode mergeKLists(ListNode[] lists) {
    static int mergeKLists(ListNode[] lists) {

        Comparator<ListNode> cmp;
        cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };

        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);

        for (ListNode l : lists) {
            if (l != null) {
                q.add(l);
            }
        }

        ListNode head = new ListNode(0);
        ListNode point = head;

        while (!q.isEmpty()) {
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;

            if (next != null) {
                q.add(next);
            }
        }

//        return head.next;
        return head.next.val;
    }

    public static void main(String[] args) {

        // Example 1:
        int[][] arrayLists = {{1,4,5},{1,3,4},{2,6}};
        //  O/P: [1,1,2,3,4,4,5,6]

        int[] dataArray1 = arrayLists[0];
        int[] dataArray2 = arrayLists[1];
        int[] dataArray3 = arrayLists[2];

        ListNode head1 = new ListNode(dataArray1[0]);
        ListNode current1 = head1;

        ListNode head2 = new ListNode(dataArray2[0]);
        ListNode current2 = head2;

        ListNode head3 = new ListNode(dataArray3[0]);
        ListNode current3 = head3;

        for (int i = 1; i < dataArray1.length; i++) {

            ListNode node = new ListNode(dataArray1[i]);

            current1.next = node;
            current1 = node;
        }

        for (int i = 1; i < dataArray2.length; i++) {

            ListNode node = new ListNode(dataArray1[i]);

            current2.next = node;
            current2 = node;
        }

        for (int i = 1; i < dataArray3.length; i++) {

            ListNode node = new ListNode(dataArray3[i]);

            current3.next = node;
            current3 = node;
        }

        ListNode[] lists = {head1, head2, head3};

        // Example 2:
//        int[] lists = []
        //  O/P: []

        // Example 3:
//        int[] lists = [[]]
        //  O/P: []

        System.out.println(mergeKLists(lists));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

