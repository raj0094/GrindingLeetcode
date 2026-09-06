
class Solution {

    public void  inorder(TreeNode root,ArrayList<Integer> ans){
        if(root == null) return ;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
        

    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans.get(k-1);
        // for(int i = 0; i<ans.size();i++){
        //     if(ans.get(i)==k) return ans.get(i);
        // }

        // return 0;

        
    
        
    }
   
}