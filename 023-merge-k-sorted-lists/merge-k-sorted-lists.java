// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)return null;
        Queue <ListNode>queue = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1,ListNode l2){
                if(l1.val<l2.val)return -1;
                if(l1.val>l2.val)return 1;
                else return 0;
            }
            }
            );
            ListNode result = new ListNode(1);
            ListNode temp = result;
            for(ListNode i:lists){
                if(i!=null)
                queue.add(i);
            }
            while(!queue.isEmpty()){
                temp.next = queue.poll();
                temp = temp.next;
                if(temp.next!=null)queue.add(temp.next);
            }
            return result.next;
    }
}
