// Reverse a singly linked list.
//
// click to show more hints.
//
// Hint:
// A linked list can be reversed either iteratively or recursively. Could you implement both?


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        // ListNode newHead = null;
        // while(head!=null){
        //     ListNode next = head.next;
        //     head.next = newHead;
        //     newHead = head;
        //     head = next;
        // }
        // return newHead;
        return reverse(head,null);
    }
    public ListNode reverse(ListNode head,ListNode newHead){
        if(head==null)return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverse(next,head);
    }
}
