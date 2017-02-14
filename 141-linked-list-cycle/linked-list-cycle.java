// Given a linked list, determine if it has a cycle in it.
//
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
    public boolean hasCycle(ListNode head) {
       if(head==null)return false;
       ListNode n = head;
       ListNode nn = head;
       while(true){
               if(n.next==null)return false;
               else n=n.next;
               if(nn.next==null||nn.next.next==null)return false;
               else nn=nn.next.next;
               if(n==nn)return true;
       }
    }
}
