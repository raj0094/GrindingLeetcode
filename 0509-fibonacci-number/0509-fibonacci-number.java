class Solution {
    public int fibo(int n,int[] dp) {
        if(n<=1) return n;
        if(dp[n] != 0) return dp[n];
        int ans = fibo(n-1,dp) + fibo(n-2,dp);
        dp[n] = ans;
        return ans;
       
    }
    public int fib(int n) {
        // recursive
        // if (n == 0 || n == 1) {
        //     return n;
        // }
        // return fib(n - 1) + fib(n - 2);
        int[] dp = new int[n+1];
        return fibo(n,dp);
    }
}