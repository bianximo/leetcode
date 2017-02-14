// Sort a linked list in O(n log n) time using constant space complexity.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode last = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(last);
        return merge(l1,l2);
    }
    public ListNode merge(ListNode l1,ListNode l2){
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode newHead = new ListNode(-1);
        ListNode current = newHead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                current.next = l1;
                l1 = l1.next;
                current = current.next;
            }else{
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            }
        }
        while(l1!=null){
            current.next = l1;
                l1 = l1.next;
                current = current.next;
        }
        while(l2!=null){
            current.next = l2;
                l2 = l2.next;
                current = current.next;
        }
        return newHead.next;
    }
    
}
