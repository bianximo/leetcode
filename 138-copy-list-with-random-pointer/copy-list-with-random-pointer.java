// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
//
//
// Return a deep copy of the list.


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)return null;
        RandomListNode current = head;
        while(current!=null){
            RandomListNode temp = new RandomListNode(current.label);
            temp.next = current.next;
            current.next = temp;
            current = temp.next;
        }
        current = head;
        while(current!=null){
            RandomListNode temp = current.random;
            if(temp!=null){
                current.next.random = temp.next;
            }
            current = current.next.next;
        }
        RandomListNode head2 = head.next;
        current = head;
        while(current!=null&&current.next!=null){
            if(current.next.next==null){
                current.next = null;
                break;
            }
            RandomListNode temp = current.next;
            current.next = current.next.next;
            temp.next = temp.next.next;
            current = current.next;
        }
        return head2;
        
    }
}
