class Solution {
    public int helper(int[] nums, int st, int end) {
        int len = end - st + 1;

        int[] dp = new int[len];

        dp[0] = nums[st];
        if (len == 1) return dp[0];

        dp[1] = Math.max(nums[st], nums[st + 1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(
                nums[st + i] + dp[i - 2],
                dp[i - 1]
            );
        }

        return dp[len - 1];
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        return Math.max(
            helper(nums, 0, n - 2),
            helper(nums, 1, n - 1)
        );
    }
}