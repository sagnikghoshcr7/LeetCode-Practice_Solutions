class Solution {
    public int rob(int[] a) {
        int n = a.length;
        int[][] dp = new int[2][n];
        // dp[0][i] -> max money from 0 to ith house if (i-1)th not looted
        // dp[1][i] -> max money from 0 to ith house if (i-1)th looted
        dp[0][0] = 0; dp[1][0] = a[0];

        for (int i=1; i<n; i++) {
            dp[0][i] = dp[1][i-1];
            dp[1][i] = Math.max(dp[0][i-1] + a[i], dp[1][i-1]);
        }

        return Math.max(dp[0][n-1], dp[1][n-1]);
    }
}