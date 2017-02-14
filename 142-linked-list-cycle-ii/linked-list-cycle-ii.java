// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//
//
// Note: Do not modify the linked list.
//
//
// Follow up:
// Can you solve it without using extra space?


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
    public ListNode detectCycle(ListNode head) {
        ListNode n = hasCycle(head);
        if(n==null)return null;
        ListNode nn = head;
        while(true){
            if(n==nn)return n;
            else{
                n=n.next;
                nn=nn.next;
            }
        }
    
    }
    public ListNode hasCycle(ListNode head) {
       if(head==null)return null;
       ListNode n = head;
       ListNode nn = head;
       while(true){
               if(n.next==null)return null;
               else n=n.next;
               if(nn.next==null||nn.next.next==null)return null;
               else nn=nn.next.next;
               if(n==nn)return n;
       }
    }
}
