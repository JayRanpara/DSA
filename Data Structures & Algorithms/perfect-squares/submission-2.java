class Solution {
    public static int numSquaresMemo(int n, int[] dp) {
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];  // reuse stored result

        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, 1 + numSquaresMemo(n - i * i, dp));
        }

        dp[n] = min;  // store result for this n
        return dp[n];
    }
    public int numSquarestab(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }

        return dp[n];
    }

    public int numSquares(int n) {
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return numSquaresMemo(n, dp);
        return numSquarestab(n);
    }
}
