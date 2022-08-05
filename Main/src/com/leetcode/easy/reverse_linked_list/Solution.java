package com.leetcode.easy.reverse_linked_list;

//Given the head of a singly linked list, reverse the list, and return the
//reversed list.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
//
//
// Example 2:
//
//
//Input: head = [1,2]
//Output: [2,1]
//
//
// Example 3:
//
//
//Input: head = []
//Output: []
//
//
//
// Constraints:
//
//
// The number of nodes in the list is the range [0, 5000].
// -5000 <= Node.val <= 5000
//
//
//
// Follow up: A linked list can be reversed either iteratively or recursively.
//Could you implement both?
// Related Topics Linked List Recursion 👍 13192 👎 230


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

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

//class LinkedList {
//
//
//
//}

class Solution {

//    static ListNode reverseList(ListNode head) {
    static int reverseList(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

//        return prev;
        return prev.data;
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

        int[] headArray = {1,2,3,4,5};

        ListNode head = new ListNode(headArray[0]);
        ListNode current = head;

        for (int i = 1; i < headArray.length; i++) {

            ListNode node = new ListNode(headArray[i]);
            current.next = node;
            current = node;

        }

//        ListNode nodeA = new ListNode(1);
//        ListNode nodeB = new ListNode(2);
//        ListNode nodeC = new ListNode(3);
//        ListNode nodeD = new ListNode(4);
//        ListNode nodeE = new ListNode(5);
//
//        nodeA.next = nodeB;
//        nodeB.next = nodeC;
//        nodeC.next = nodeD;
//        nodeD.next = nodeE;

        System.out.println(countNodes(head));
        System.out.println(reverseList(head));

//        System.out.println();
//        System.out.println(countNodes(nodeA));
//        System.out.println(reverseList(nodeA));

    }
}
