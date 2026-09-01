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

    public TreeNode predicessor(TreeNode root,TreeNode curr){
        TreeNode ip = curr.left;
        while(ip.right != null && ip.right != curr){
            ip = ip.right;
        }
        return ip;
        
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode pred = predicessor(root,curr);
                if(pred.right == null){
                    pred.right = curr; // new temp connection form
                    curr = curr.left;
                }
                else{
                    pred.right = null; // delete temp connection
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
        
    }
}