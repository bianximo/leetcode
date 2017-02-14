// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//
// You must do this in-place without altering the nodes' values.
//
//
// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)return;
        ListNode slow = head,fast = head,pre=null;
        
        while(fast!=null&&fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode lastPart = reverse(slow);
        merge(head,lastPart);
    }
    
    
    void merge(ListNode l1, ListNode l2) {
      while (l1 != null) {
        ListNode n1 = l1.next, n2 = l2.next;
        l1.next = l2;
        if (n1 == null)
          break;
        l2.next = n1;
        l1 = n1;
        l2 = n2;
      }
    }
    ListNode reverse(ListNode head) {
      ListNode prev = null, curr = head, next = null;
      while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      return prev;
    }
}
