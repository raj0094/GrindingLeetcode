
class Solution {

    public void insert(TreeNode root, int val,  TreeNode temp){
        if(root.val < val){   // attach to right
            if(root.right == null){
                root.right = temp;
            }
            else{
                insert( root.right, val,temp);
            }
        }
        if(root.val > val){   // attach to right
            if(root.left == null) {
                root.left = temp;
            }
            else{
                insert(root.left,val,temp);
            }
        }
        

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = new TreeNode(val);
        if(root == null) return temp;
        insert(root,val,temp);
        return root;

        
    }
}