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
  
   private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    private TreeNode buildBalancedBST(List<Integer> list, int low, int high) {
        // Base case: range is invalid
        if (low > high) return null;

        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(list.get(mid));

        // Recursively build left and right subtrees
        node.left = buildBalancedBST(list, low, mid - 1);
        node.right = buildBalancedBST(list, mid + 1, high);

        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
       List<Integer> sortedNodes = new ArrayList<>();
        inorder(root, sortedNodes);
        return buildBalancedBST(sortedNodes, 0, sortedNodes.size() - 1);        
    }
}