// Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length==0||inorder.length==0)return null;
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;
    }
    public TreeNode buildTree(int[]preorder,int begin1,int end1,int[]inorder,int begin2,int end2){
        if(begin1>=preorder.length||end1<0||begin2>=inorder.length||end2<0)return null;
        if(begin1>end1)return null;
        TreeNode root = new TreeNode(preorder[begin1]);
        if(begin1==end1)return root;
        int index = 0;
        for(int i=begin2;i<=end2;i++){
            if(preorder[begin1]==inorder[i]){
                index = i;
                break;
            }
        }
        root.left = buildTree(preorder,begin1+1,begin1+(index-begin2),inorder,begin2,index-1);
        root.right = buildTree(preorder,begin1+(index-begin2)+1,end1,inorder,index+1,end2);
        return root;
    }
}
