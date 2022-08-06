package com.leetcode.easy.palindrome_linked_list;

class ListNode {
    int data;
    ListNode next;

    ListNode (int data) {
        this.data = data;
    }
}

public class Solution {

    //Given the head of a singly linked list, return true if it is a palindrome.
    //
    //
    // Example 1:
    //
    //
    //Input: head = [1,2,2,1]
    //Output: true
    //
    //
    // Example 2:
    //
    //
    //Input: head = [1,2]
    //Output: false
    //
    //
    //
    // Constraints:
    //
    //
    // The number of nodes in the list is in the range [1, 10⁵].
    // 0 <= Node.val <= 9
    //
    //
    //
    //Follow up: Could you do it in
    //O(n) time and
    //O(1) space?
    //
    // Related Topics Linked List Two Pointers Stack Recursion 👍 9897 👎 602


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

    static boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode firstHalfHead = head;
        ListNode secondHalfHead = reverseLinkedList(slow.next);

        while (firstHalfHead != null && secondHalfHead != null){
//            if (firstHalfHead.val != secondHalfHead.val) {
            if (firstHalfHead.data != secondHalfHead.data) {
                return false;
            }

            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;

        }

        return true;

    }

    static private ListNode reverseLinkedList(ListNode head) {

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {

        // Example 1:
        int[] head1Array = {1,2,2,1};
        //  O/P: true

        // Example 2:
        int[] head2Array = {1,2};
        //  O/P: false

        ListNode head1 = new ListNode(head1Array[0]);
        ListNode current1 = head1;

        for (int i = 1; i < head1Array.length; i++) {

            ListNode node = new ListNode(head1Array[i]);

            current1.next = node;
            current1 = node;
        }

        ListNode head2 = new ListNode(head1Array[0]);
        ListNode current2 = head2;

        for (int i = 1; i < head2Array.length; i++) {

            ListNode node = new ListNode(head2Array[i]);

            current2.next = node;
            current2 = node;
        }

        System.out.println("Example 1: " + isPalindrome(head1));
        System.out.println("Example 1: " + isPalindrome(head2));
    }

}
//leetcode submit region end(Prohibit modification and deletion)

