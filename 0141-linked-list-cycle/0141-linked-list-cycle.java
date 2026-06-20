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
public class Solution {
    public boolean hasCycle(ListNode head) {
       if (head== null) return false;
        ListNode fast =head;
        ListNode slow =head;
        int length =0;
        // if there is one element then loop me nhi jayega coz fast.next == null
        // if there is two element then fast.next.next can be null and cannt be;
        while(fast !=null&& fast.next !=null ){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
              return true;
            }
        }
        return false;
    }
}