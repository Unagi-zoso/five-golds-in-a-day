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
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddsHead = head;
        ListNode oddsTail = head;
        ListNode evensHead = head.next;
        ListNode evensTail = head.next;
        oddsTail.next = evensTail.next;
        if (oddsTail.next != null) oddsTail = oddsTail.next;
        while (oddsTail.next != null) {
            evensTail.next = oddsTail.next;
            evensTail = evensTail.next;
            oddsTail.next = evensTail.next;
            if (oddsTail.next == null) break;
            oddsTail = oddsTail.next;
        }

        oddsTail.next = evensHead;
        evensTail.next = null;
        return oddsHead;
    }
}