class Solution {

    public void helper(TreeNode root, int target,
                       ArrayList<Integer> arr,
                       List<List<Integer>> ans) {

        if (root == null) return;

        // Add current node to path
        arr.add(root.val);

        // If leaf node
        if (root.left == null && root.right == null) {

            if (root.val == target) {
                ans.add(new ArrayList<>(arr));
            }

            return;
        }

        // Create separate copies for both paths
        ArrayList<Integer> arr1 = new ArrayList<>(arr);
        ArrayList<Integer> arr2 = new ArrayList<>(arr);

        helper(root.left, target - root.val, arr1, ans);
        helper(root.right, target - root.val, arr2, ans);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();

        ArrayList<Integer> arr = new ArrayList<>();

        helper(root, targetSum, arr, ans);

        return ans;
    }
}