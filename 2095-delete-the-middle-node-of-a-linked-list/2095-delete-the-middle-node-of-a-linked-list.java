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
        if(head == null || head.next == null) return null;

        ListNode slowprev = new ListNode(-1);
        slowprev.next = head ;
        ListNode fast = head;

        while (fast!= null && fast.next!= null){
            slowprev = slowprev.next;
            fast = fast.next.next;
        }
        // slow is middle now
        slowprev.next = slowprev.next.next;
        return head ;
    }
}