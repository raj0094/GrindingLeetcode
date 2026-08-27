class Solution {
    public TreeNode isExist(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) return isExist(root.right, p, q);
        else if (root.val > p.val && root.val > q.val) return isExist(root.left, p, q);
        else return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return isExist(root, p, q);
    }
}