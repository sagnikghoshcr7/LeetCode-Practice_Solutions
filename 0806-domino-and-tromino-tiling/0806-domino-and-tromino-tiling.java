class Solution {
    private static final int MOD = 1000000007;

    public int numTilings(int n) {
        int[][] dp = new int[n + 2][2];
        dp[1][0] = 1; dp[1][1] = 1; dp[2][0] = 2; dp[2][1] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i][0] = (int)((dp[i - 1][0] + dp[i - 2][0] + 2L * dp[i - 2][1]) % MOD);
            dp[i][1] = (int)((dp[i - 1][0] + dp[i - 1][1]) % MOD);
        }

        return dp[n][0];
    }
}


// https://leetcode.com/problems/domino-and-tromino-tiling/solutions/1620975/c-python-simple-solution-w-images-explanation-optimization-from-brute-force-to-dp