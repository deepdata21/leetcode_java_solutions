package com.leetcode.easy.middle_node;

class ListNode {
    int data;
    ListNode next;

    ListNode (int data) {
        this.data = data;
    }
}

public class Solution {

    //Given the head of a singly linked list, return the middle node of the linked
    //list.
    //
    // If there are two middle nodes, return the second middle node.
    //
    //
    // Example 1:
    //
    //
    //Input: head = [1,2,3,4,5]
    //Output: [3,4,5]
    //Explanation: The middle node of the list is node 3.
    //
    //
    // Example 2:
    //
    //
    //Input: head = [1,2,3,4,5,6]
    //Output: [4,5,6]
    //Explanation: Since the list has two middle nodes with values 3 and 4, we
    //return the second one.
    //
    //
    //
    // Constraints:
    //
    //
    // The number of nodes in the list is in the range [1, 100].
    // 1 <= Node.val <= 100
    //
    // Related Topics Linked List Two Pointers 👍 5814 👎 150


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

    static ListNode head;
    static ListNode tail;

//    static ListNode findMiddleNode(ListNode head) {
    static int findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
//        return slow;
        return slow.data;
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
        //  Input: head = [1,2,3,4,5]
        //  Output: [3,4,5]

        int[] dataArray = {1, 2, 3, 4, 5};

        ListNode head = new ListNode(dataArray[0]);
        ListNode current = head;

        for (int i = 1; i < dataArray.length; i++) {

            ListNode node = new ListNode(dataArray[i]);

            current.next = node;
            current = node;
        }

        System.out.println(countNodes(head));
        System.out.println(findMiddleNode(head));
    }
}
