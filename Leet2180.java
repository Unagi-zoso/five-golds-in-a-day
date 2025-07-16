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
    public int pairSum(ListNode head) {
        int n = 0;
        ListNode next = head;
        while (next != null) {
            next = next.next;
            n++;
        }
        int[] twinSums = new int[n/2];
        next = head;
        int i = 0;
        while (next != null) {
            if (i < n/2) {
                twinSums[i] += next.val;
            } else {
                twinSums[n-1-i] += next.val;
            }
            i++;
            next = next.next;
        }
        int ans = -1;
        for (int sum : twinSums) ans = Math.max(ans, sum);
        return ans;
    }
}