class Solution {

    // TOP-DOWN DP
    /*public int fibo(int n,int[] dp) {
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
    }*/

    // TABULER DP

    public int fib(int n){
        if(n<=1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i =2 ;i <=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];

    }
}