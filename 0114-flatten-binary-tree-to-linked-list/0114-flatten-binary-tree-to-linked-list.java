
class Solution {
    public void flatten(TreeNode root) {
        // break the tree;
        if(root == null) return;
        if(root.left == null && root.right == null ) return ;
        TreeNode LST = root.left;
        TreeNode RST = root.right;


        // flatten the LST and RST 
        flatten(LST);
        flatten(RST);

        // arrange in correct order
        root.right = LST;
        root.left = null;
       
        if(LST != null){    // if LST is  null
             TreeNode temp = LST;
             while(temp.right!=null){
                temp = temp.right;
            }
            temp.right = RST;
        }else{
            root.right = RST;
        }

        
       

        




        
       
    }
}