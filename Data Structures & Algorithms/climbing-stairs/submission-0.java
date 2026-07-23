class Solution {
    public static int mem(int n, int dp[]) {
        if(n==0){
            return dp[0];
        }
        if(n == 1) {
            return dp[1];
        }
        if(dp[n]!=-1) {
            return dp[n];
        }
        dp[n] = mem(n-1,dp)+mem(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        // if(n==0){
        //     return 1;
        // }
        // if(n == 1) {
        //     return 1;
        // }
        // return climbStairs(n-1)+climbStairs(n-2);

        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        dp[1] = 1;

        return mem(n,dp);
    }
}
