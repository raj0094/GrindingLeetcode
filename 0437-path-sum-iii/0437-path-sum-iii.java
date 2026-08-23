class Solution {
    int totalCount = 0; // Global tracker

    public int pathSum(TreeNode root, int sum) {
        traverse(root, sum);
        return totalCount;
    }

    // Traverses every node and triggers the helper
    private void traverse(TreeNode root, int sum) {
        if (root == null) return;

        // Add paths starting at current node directly to totalCount
        totalCount += helper(root, sum);

        // Keep traversing
        traverse(root.left, sum);
        traverse(root.right, sum);
    }

    private int helper(TreeNode root, long sum) {
        if (root == null) return 0;
        int count = 0;
        if (root.val == sum) count++;

        int left =  helper(root.left, sum - root.val);
        int right = helper(root.right, sum - root.val);
        count += left + right;
        return count;
    }
}