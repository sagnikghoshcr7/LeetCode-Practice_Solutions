class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (i - 1 >= 0 && grid[i - 1][j - 1] < grid[i][j])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
                if (grid[i][j - 1] < grid[i][j])
                    dp[i][j] = Math.max(dp[i][j],  dp[i][j - 1]);
                if (i + 1 < m && grid[i + 1][j - 1] < grid[i][j])
                    dp[i][j] = Math.max(dp[i][j],  dp[i + 1][j - 1]);
                if (dp[i][j] > 0) dp[i][j]++;
                res = Math.max(res, dp[i][j] - 1);
            }
        }
        return res;
    }
}