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


    public TreeNode inorderpred(TreeNode root){
        TreeNode temp = root.left;
        while(temp.right!= null){
            temp = temp.right;
        }
        return temp;
    }
    public TreeNode parent(TreeNode root, TreeNode pred){
        if(root.left == pred || root.right == pred) return root;  // root is parent
        TreeNode temp = root.left;
        while(temp.right!= pred){
            temp = temp.right;
        }
        return temp;

    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){  //deletion

            // case 1: 0 child node leaf

            if(root.left == null && root.right == null) return null;

            // case 2: 1 child node is there

            if(root.left == null || root.right ==  null){
                if(root.left == null) return root.right;  // attach right
                else return root.left;  // atttach left 
            }

            // case 3: both child is there

            TreeNode pred = inorderpred(root);
            TreeNode predparent = parent(root,pred);
            if(predparent == root){
                pred.right = root.right;
                return pred;
            }
            predparent.right = pred.left;
            pred.left = root.left;
            pred.right = root.right;
            return pred;
        }
        else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        else if(root.val > key){
            root.left= deleteNode(root.left,key);
        }

        return  root;
        
        
    }
}