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
    static int sum =0;
    public void reverseinorder(TreeNode root){
        if(root == null) return;
       reverseinorder(root.right);
        root.val += sum;
        sum = root.val;
        reverseinorder(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        sum =0 ;
        reverseinorder(root);
        return root;
       
        
    }
}