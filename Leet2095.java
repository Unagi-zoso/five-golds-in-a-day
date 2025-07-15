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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode first = head;
        ListNode second = head;
        ListNode prevSec = second;
        while (first != null && first.next != null) {
            for (int i = 0; i < 2; i++) {
                if (first.next == null) break;
                first = first.next; 
            }

            prevSec = second;
            second = second.next;
        }
        prevSec.next = second.next;
        return head;
    }
}