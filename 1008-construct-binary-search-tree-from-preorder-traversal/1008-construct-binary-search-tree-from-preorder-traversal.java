class Solution {

    int preIndex = 0;

    public TreeNode helper(int[] preorder, int[] inorder, int low, int high) {
        if (low > high) return null;

        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);

        int mid = low;
        while (inorder[mid] != rootValue) {
            mid++;
        }

        root.left = helper(preorder, inorder, low, mid - 1);
        root.right = helper(preorder, inorder, mid + 1, high);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;

        int[] inorder = Arrays.copyOf(preorder, n);
        Arrays.sort(inorder);

        return helper(preorder, inorder, 0, n - 1);
    }
}