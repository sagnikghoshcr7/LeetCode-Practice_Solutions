class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n]; // dp[i][j] -> LCS in string from i to j;

        for (int i=0; i<n; i++) dp[i][i] = 1;

        for (int L=2; L<=n; L++) {
            for (int i=0; i<n-L+1; i++) {
                int j = i+L-1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (L == 2) dp[i][j] = 2;
                    else dp[i][j] = 2 + dp[i+1][j-1];
                }
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }

        return n - dp[0][n-1];
    }
}