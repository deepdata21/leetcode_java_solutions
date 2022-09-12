package com.leetcode.medium.remove_nth_from_end_of_list;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {

//Given the head of a linked list, remove the nᵗʰ node from the end of the list
//and return its head.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
//
//
// Example 2:
//
//
//Input: head = [1], n = 1
//Output: []
//
//
// Example 3:
//
//
//Input: head = [1,2], n = 1
//Output: [1]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
//
//
// Follow up: Could you do this in one pass?
// Related Topics Linked List Two Pointers 👍 10707 👎 502


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

//    static ListNode removeNthFromEnd(ListNode head, int n) {
    static int removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
//        return dummy.next;
        return dummy.next.val;
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

        //Input: head = [1,2,3,4,5], n = 2
        //Output: [1,2,3,5]

        int[] valArray = {1, 2, 3, 4, 5};
        int n = 2;

        ListNode head = new ListNode(valArray[0]);
        ListNode current = head;

        for (int i = 1; i < valArray.length; i++) {
            ListNode node = new ListNode(valArray[i]);
            current.next = node;
            current = node;
        }

        System.out.println(countNodes(head));
        System.out.println(removeNthFromEnd(head, n));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

