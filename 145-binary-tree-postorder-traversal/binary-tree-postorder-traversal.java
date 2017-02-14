// Given a binary tree, return the postorder traversal of its nodes' values.
//
//
// For example:
// Given binary tree {1,#,2,3},
//
//    1
//     \
//      2
//     /
//    3
//
//
//
// return [3,2,1].
//
//
// Note: Recursive solution is trivial, could you do it iteratively?


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>list = new ArrayList<>();
         poster(root,list);
        return  list;
    }
    private void poster(TreeNode node ,List<Integer>list){
       if(node==null)return;
       if(node.left!=null)poster(node.left,list);
       if(node.right!=null)poster(node.right,list);
       list.add(node.val);
    }
}
