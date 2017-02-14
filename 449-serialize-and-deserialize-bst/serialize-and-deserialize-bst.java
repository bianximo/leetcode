// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment. 
//
// Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
//
// The encoded string should be as compact as possible.
//
//
//
// Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public static final String SEP = ",";
	private static final String NULL = "null";
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        if(root==null)return NULL;
        Stack<TreeNode>stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            s.append(node.val).append(SEP);
            if(node.right!=null)stack.push(node.right);
            if(node.left!=null)stack.push(node.left);
        }
        return s.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(NULL)) return null;
        String[] strs = data.split(SEP);
        Queue<Integer> q = new LinkedList<>();
        for (String e : strs) {
            q.offer(Integer.parseInt(e));
        }
        return getNode(q);
    }
    private TreeNode getNode(Queue<Integer> q) { //q: 5,3,2,6,7
        if(q.isEmpty())return null;
        TreeNode root = new TreeNode(q.poll());
        Queue<Integer>smallQueue = new LinkedList<>();
        while(!q.isEmpty()&&q.peek()<=root.val){
            smallQueue.offer(q.poll());
        }
        root.left = getNode(smallQueue);
        root.right = getNode(q);
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
