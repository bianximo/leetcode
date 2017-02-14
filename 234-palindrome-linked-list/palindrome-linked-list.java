// Given a singly linked list, determine if it is a palindrome.
//
// Follow up:
// Could you do it in O(n) time and O(1) space?


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    if (fast != null) { // odd nodes: let right half smaller
        slow = slow.next;
    }
    slow = reverse(slow);
    fast = head;
    while(slow!=null&&fast!=null){
        if(slow.val!=fast.val)return false;
        slow = slow.next;
        fast = fast.next;
    }
    return true;
    }
    
    public ListNode reverse(ListNode head){
       ListNode newHead = null;
       while(head!=null){
           ListNode temp = head.next;
           head.next = newHead;
           newHead = head;
           head = temp;
       }
       return newHead;
    }
    
    
}
