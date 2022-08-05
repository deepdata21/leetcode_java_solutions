package com.leetcode.easy.merge_two_sorted_lists;

class ListNode {
    int data;
    ListNode next;

    ListNode(int num) {
        this.data = num;
        this.next = null;
    }
}

public class Solution {

    //You are given the heads of two sorted linked lists list1 and list2.
    //
    // Merge the two lists in a one sorted list. The list should be made by
    //splicing together the nodes of the first two lists.
    //
    // Return the head of the merged linked list.
    //
    //
    // Example 1:
    //
    //
    //Input: list1 = [1,2,4], list2 = [1,3,4]
    //Output: [1,1,2,3,4,4]
    //
    //
    // Example 2:
    //
    //
    //Input: list1 = [], list2 = []
    //Output: []
    //
    //
    // Example 3:
    //
    //
    //Input: list1 = [], list2 = [0]
    //Output: [0]
    //
    //
    //
    // Constraints:
    //
    //
    // The number of nodes in both lists is in the range [0, 50].
    // -100 <= Node.val <= 100
    // Both list1 and list2 are sorted in non-decreasing order.
    //
    // Related Topics Linked List Recursion 👍 12905 👎 1175


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    static ListNode merge(ListNode head1, ListNode head2) {

        ListNode mergedList;
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.data < head2.data) {
            //point to smaller element
            mergedList = head1;
            mergedList.next = merge(head1.next, head2);
        } else { //head1 is large, so pass h
            //point to smaller element
            mergedList = head2;
            //head2 is already considered
            //now process next node of head2
            mergedList.next = merge(head1, head2.next);
        }
        return mergedList;
    }

    static int countNodes (ListNode head) {

        int count = 1;
        ListNode current = head;

        while (current.next != null){

            current = current.next;
            count++;

        }

        return count;
    }

    public static void main(String[] args) {
        //  Example 1:
        //  Output: [1,1,2,3,4,4]
        //  Input: list1 = [1,2,4], list2 = [1,3,4]

//        int[] ex1data1 = {1,2,4};
        int[] ex1data1 = {2, 4, 5};
        ListNode head1ex1 = new ListNode(ex1data1[0]);
        ListNode current1Ex1 = head1ex1;

        for (int i = 1; i < ex1data1.length; i++) {
            ListNode node = new ListNode(ex1data1[i]);
            current1Ex1.next = node;
            current1Ex1 = node;
        }

        System.out.println("Ex1 (Head 1) - # of Nodes: " + countNodes(head1ex1));

//        int[] ex1data = {1,3,4};
        int[] ex1data2 = {3,4,6,7};
        ListNode head2ex1 = new ListNode(ex1data2[0]);
        ListNode current2Ex1 = head2ex1;

        for (int i = 1; i < ex1data2.length; i++) {
            ListNode node = new ListNode(ex1data2[i]);
            current2Ex1.next = node;
            current2Ex1 = node;
        }

        System.out.println("Ex1 (Head 2) - # of Nodes: " + countNodes(head2ex1));

        ListNode mergedListEx1 = merge(head1ex1, head2ex1);

        System.out.println("Ex1 (merged list) - # of Nodes: " + countNodes(mergedListEx1));
        System.out.println("Ex1 (merged list) - Head: " + mergedListEx1.data);
        System.out.println();

        int[] ex2data1 = {1, 3, 5, 9};
        ListNode head1ex2 = new ListNode(ex2data1[0]);
        ListNode current1Ex2 = head1ex2;

        for (int i = 1; i < ex2data1.length; i++) {
            ListNode node = new ListNode(ex2data1[i]);
            current1Ex2.next = node;
            current1Ex2 = node;
        }

        System.out.println("Ex2 (Head 1) - # of Nodes: " + countNodes(head1ex2));

        int[] ex2data2 = {2, 4, 5, 6, 10};
        ListNode head2ex2 = new ListNode(ex2data2[0]);
        ListNode current2Ex2 = head2ex2;

        for (int i = 1; i < ex2data2.length; i++) {
            ListNode node = new ListNode(ex2data2[i]);
            current2Ex2.next = node;
            current2Ex2 = node;
        }

        System.out.println("Ex2 (Head 2) - # of Nodes: " + countNodes(head2ex2));

        ListNode mergedListEx2 = merge(head1ex2, head2ex2);

        System.out.println("Ex2 (merged list) - # of Nodes: " + countNodes(mergedListEx2));
        System.out.println("Ex2 (merged list) - Head: " + mergedListEx2.data);

        //  Example 2:
        //  Output: []
        //  Input: list1 = [], list2 = []

        //  Example 3:
        //  Input: list1 = [], list2 = [0]
        //  Output: [0]

    }
}