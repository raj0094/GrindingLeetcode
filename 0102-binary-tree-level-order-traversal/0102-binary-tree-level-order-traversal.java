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

    public class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }

    }

    public int levels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }

    public void nthudingqueue(TreeNode root,List<List<Integer>> ans) {
      Queue<Pair> q1 = new LinkedList<>();
      Pair p  = new Pair(root, 0);
      if(root != null) q1.add(p);
      while (q1.size()>0) {
         Pair front = q1.remove();
         TreeNode temp = front.node;
         int lvl = front.level;

         ans.get(lvl).add(temp.val);
         
         if (temp.left != null)
            q1.add(new Pair(temp.left, lvl+1));
         if (temp.right != null)
            q1.add(new Pair(temp.right, lvl+1));
        }
    }
   
    public List<List<Integer>> levelOrder(TreeNode root) {
        int lvl = levels(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =1; i<=lvl;i++){
            List<Integer> arr = new ArrayList<>();  
            ans.add(arr);
        }
        nthudingqueue(root,ans);
        return ans;

        
    }
}