
class Solution {
    public void inorder(TreeNode root ,Stack<Integer> arr  ){
        if(root == null) return ;
        inorder(root.right, arr);
        arr.push(root.val);
        inorder(root.left,arr);

    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {


       List<Integer> ans = new ArrayList<>();

       Stack<Integer> a = new Stack<>();
       Stack<Integer> b = new Stack<>();

       inorder(root1,a);
       inorder(root2,b);

       while(!a.isEmpty() && !b.isEmpty()){
        if (a.peek() < b.peek()) {
    ans.add(a.pop());
} else {
    ans.add(b.pop());
}
       }


       while(!a.isEmpty()){
        ans.add(a.peek());
        a.pop();
       }
while(!b.isEmpty()){
        ans.add(b.peek());
        b.pop();
       }

       return ans;
          
         
    

       

        
    }
}