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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode prev = slow;
        ListNode fast = head;

        while(n-->0){
            fast = fast.next ;
        }

        while(fast!= null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = slow.next ;
        if(slow == head) return head.next;
        slow.next = null;

        return head ;
    }
}