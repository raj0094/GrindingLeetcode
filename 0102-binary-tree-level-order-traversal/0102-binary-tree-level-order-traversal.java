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

     public void nthLevel(TreeNode root , int level, int lvl, List<Integer> arr ){
      if (root == null) return;
      if(level==lvl ) arr.add(root.val); // when level is equal to the given level then it print
      nthLevel(root.left,level+1,lvl,arr);
       nthLevel(root.right,level+1,lvl,arr);
     

   }

    public int levels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int lvl = levels(root);
        for(int i =0 ;i<=lvl-1;i++){
            List<Integer> arr = new ArrayList<>(); 
            nthLevel(root,0,i,arr);
            ans.add(arr);


        }
        return ans;
        
    }
}