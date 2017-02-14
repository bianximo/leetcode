// Remove all elements from a linked list of integers that have value val.
//
// Example
// Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6,  val = 6
// Return: 1 --> 2 --> 3 --> 4 --> 5
//
//
// Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)return null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode current = newHead;
        ListNode next = head;
        while(next!=null){
            if(next.next==null){
                if(next.val==val){
                    current.next=null;
                }
                break;
            }
            if(next.val==val){
                current.next = next.next;
                next = current.next;
            }else{
                current = current.next;
                next = current.next;
            }
        }
        return newHead.next;
    }
}
