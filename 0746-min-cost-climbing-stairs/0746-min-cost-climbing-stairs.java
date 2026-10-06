class Solution {
    /*public static int mincost(int[] cost ,int idx,int[] dp){
        if(idx == 0||idx == 1) return cost[idx];
        if(dp[idx] != -1) return dp[idx];
        int ans = cost[idx] + Math.min(mincost(cost,idx -1,dp),mincost(cost,idx-2,dp));
        dp[idx] = ans;
        return ans;
       

    }*/
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp,-1);
        // return Math.min(mincost(cost,n-1,dp),mincost(cost,n-2,dp));
        
        int[] dp=new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i =2 ;i<n;i++){
            dp[i] = cost[i] + Math.min(dp[i-2],dp[i-1]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}