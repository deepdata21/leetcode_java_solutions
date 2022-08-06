package com.leetcode.medium.reorder_list;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class Solution {

    //You are given the head of a singly linked-list. The list can be represented
    //as:
    //
    //
    //L0 → L1 → … → Ln - 1 → Ln
    //
    //
    // Reorder the list to be on the following form:
    //
    //
    //L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    //
    //
    // You may not modify the values in the list's nodes. Only nodes themselves may
    //be changed.
    //
    //
    // Example 1:
    //
    //
    //Input: head = [1,2,3,4]
    //Output: [1,4,2,3]
    //
    //
    // Example 2:
    //
    //
    //Input: head = [1,2,3,4,5]
    //Output: [1,5,2,4,3]
    //
    //
    //
    // Constraints:
    //
    //
    // The number of nodes in the list is in the range [1, 5 * 10⁴].
    // 1 <= Node.val <= 1000
    //
    //
    // Related Topics Linked List Two Pointers Stack Recursion 👍 6687 👎 230


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
    static void reorderList(ListNode head) {

        if (head == null) {
            return;
        }

        //  find the middle node
        //  middle node is =slow=
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //  reverse the second part of the list node in-place
        //  head of the reversed linked-list is =prev=
        ListNode prev = null;
        ListNode current = slow;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        //  merge two sorted lists
        ListNode first = head;
        ListNode second = prev;

        while (second.next != null) {
            ListNode next = first.next;
            first.next = second;
            first = next;

            next = second.next;
            second.next = first;
            second = next;
        }

        //  Output the head
        System.out.println(head.data);
    }

    public static void main(String[] args) {
        // Example 1:
        //Input: head = [1,2,3,4]
        //  O/P: [1,4,2,3]

        // Example 2:
        //Input: head = [1,2,3,4,5]
        //  O/P: [1,5,2,4,3]

        int[] dataArray1 = {1, 2, 3, 4};

        ListNode head1 = new ListNode(dataArray1[0]);
        ListNode current1 = head1;

        for (int i = 1; i < dataArray1.length; i++) {

            ListNode node = new ListNode(dataArray1[i]);

            current1.next = node;
            current1 = node;
        }

        int[] dataArray2 = {1, 2, 3, 4, 5};

        ListNode head2 = new ListNode(dataArray2[0]);
        ListNode current2 = head2;

        for (int i = 1; i < dataArray2.length; i++) {

            ListNode node = new ListNode(dataArray2[i]);

            current2.next = node;
            current2 = node;
        }

        reorderList(head1);
        reorderList(head2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

