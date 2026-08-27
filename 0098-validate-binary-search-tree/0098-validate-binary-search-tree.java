/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long maxval(TreeNode root){
        if(root == null) return Long.MIN_VALUE;
        long  a = root.val;
        long b =  maxval(root.left);
        long c =  maxval(root.right);
        
        return Math.max(a,Math.max(b,c));
    }

    public long minval(TreeNode root){
        if(root == null) return Long.MAX_VALUE;
        long  a = root.val;
        long b = minval(root.left);
        long c = minval(root.right);
        
        return Math.min(a,Math.min(b,c));
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.val >=  minval(root.right)) return false;
        if( root.val <= maxval(root.left)) return false;  
        return  isValidBST(root.left) &&  isValidBST(root.right);

      

        
    }
}