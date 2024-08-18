class Solution {
    int BOUND = 1690;
    public int nthUglyNumber(int n) {
        // dp[i] denote the i + 1 ugly numbers
        int[] dp = new int[BOUND];
        dp[0] = 1;
        // the smallest number that is not multiplied by 2, 3, 5
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < BOUND; ++i) {
            dp[i] = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (dp[i] == dp[i2] * 2) ++i2;
            if (dp[i] == dp[i3] * 3) ++i3;
            if (dp[i] == dp[i5] * 5) ++i5;
        }
        return dp[n - 1];
    }
}