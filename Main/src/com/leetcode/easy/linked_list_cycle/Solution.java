//  Needs work to make Linked list cycle

package com.leetcode.easy.linked_list_cycle;

class ListNode {
    int data;
    ListNode next;

    ListNode (int data) {
        this.data = data;
    }
}

public class Solution {
    //Given head, the head of a linked list, determine if the linked list has a
    //cycle in it.
    //
    // There is a cycle in a linked list if there is some node in the list that can
    //be reached again by continuously following the next pointer. Internally, pos is
    //used to denote the index of the node that tail's next pointer is connected to.
    //Note that pos is not passed as a parameter.
    //
    // Return true if there is a cycle in the linked list. Otherwise, return false.
    //
    //
    //
    // Example 1:
    //
    //
    //Input: head = [3,2,0,-4], pos = 1
    //Output: true
    //Explanation: There is a cycle in the linked list, where the tail connects to
    //the 1st node (0-indexed).
    //
    //
    // Example 2:
    //
    //
    //Input: head = [1,2], pos = 0
    //Output: true
    //Explanation: There is a cycle in the linked list, where the tail connects to
    //the 0th node.
    //
    //
    // Example 3:
    //
    //
    //Input: head = [1], pos = -1
    //Output: false
    //Explanation: There is no cycle in the linked list.
    //
    //
    //
    // Constraints:
    //
    //
    // The number of the nodes in the list is in the range [0, 10⁴].
    // -10⁵ <= Node.val <= 10⁵
    // pos is -1 or a valid index in the linked-list.
    //
    //
    //
    // Follow up: Can you solve it using O(1) (i.e. constant) memory?
    //
    // Related Topics Hash Table Linked List Two Pointers 👍 9030 👎 837


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//public class Solution {
    static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] head1Array = {3,2,0,-4};
        int pos1 = 1;
        //  O/P: true

        ListNode head1 = new ListNode(head1Array[0]);
        ListNode current1 = head1;
        ListNode startNode1 = new ListNode(head1Array[pos1]);

//        for (int i = 1; i < head1Array.length; i++) {
//
//            ListNode node = new ListNode(head1Array[i]);
//
//            current1.next = node;
//            current1 = node;
//        }
//
//        current1.next = new ListNode(head1Array[1]);

        int count1 = 1;
        while(current1.next != null) {
           if (count1 == pos1) {
               startNode1 = current1;
           }
           current1 = current1.next;
           count1++;
        }

        current1.next = startNode1;

        // Example 2:
        int[] head2Array = {1,2};
        //int pos2 = 0;
        //  O/P: true

        ListNode head2 = new ListNode(head2Array[0]);
        ListNode current2 = head2;

        for (int i = 1; i < head2Array.length; i++) {

            ListNode node = new ListNode(head2Array[i]);

            current2.next = node;
            current2 = node;
        }

        // Example 3:
        int[] head3Array = {1};
        //int pos3 = -1;
        //  O/P: false

        ListNode head3 = new ListNode(head3Array[0]);
        ListNode current3 = head3;

        for (int i = 1; i < head3Array.length; i++) {

            ListNode node = new ListNode(head3Array[i]);

            current3.next = node;
            current3 = node;
        }

        System.out.println("Example 1: " + hasCycle(head1));
        System.out.println("Example 2: " + hasCycle(head2));
        System.out.println("Example 3: " + hasCycle(head3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

