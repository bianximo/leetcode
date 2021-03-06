// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        
        ListNode result = new ListNode(0);
        result.next = merge(l1,l2);
        return result.next;
        
    }
    private ListNode merge(ListNode l1,ListNode l2){
        if(l1==null&&l2!=null)return l2;
        if(l1!=null&&l2==null)return l1;
        if(l1==null&&l2==null)return null;
        else{
            if(l1.val<l2.val){
                ListNode temp = l1;
                temp.next = merge(l1.next,l2);
                return temp;
            }else{
                ListNode temp = l2;
                temp.next = merge(l1,l2.next);
                return temp;
            }
        }
    }
}
