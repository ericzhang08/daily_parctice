package rotatelist;


/**
 * 61. Rotate List
 * Medium
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */

import datastructue.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        k = k % getLinkedListLength(head);

        ListNode slow = head;
        ListNode fast = getNthNode(k, head);

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next =null;

        return head;
    }

    public int getLinkedListLength(ListNode head) {
        int length = 0;
        while (head !=null){
            length ++;
            head = head.next;
        }
        return length ++;
    }

    private ListNode getNthNode(int k, ListNode fast) {
        int i = 0;
        while (fast != null&& i<k ) {
            fast = fast.next;
            i++;
        }
        return fast;
    }
}