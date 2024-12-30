class Solution {
    public int minPathSum(int[][] A) {
        int n = A.length, m = A[0].length;
        int[][] dp = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (i == 0 && j == 0) dp[i][j] = A[i][j];
                else if (i == 0) dp[i][j] = dp[i][j-1] + A[i][j];
                else if (j == 0) dp[i][j] = dp[i-1][j] + A[i][j];
                else dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[n-1][m-1];
    }
}