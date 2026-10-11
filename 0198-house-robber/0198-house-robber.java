class Solution {
    public int amount(int[] nums,int i ,int[] dp){
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        int take = nums[i] + amount(nums,i+2,dp);
        int skip = amount(nums,i+1,dp);
        int ans = Math.max(take,skip);
        dp[i] = ans;
        return ans;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return  amount(nums,0,dp);
        
    }
}