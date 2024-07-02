class Solution {
    public int rob(int[] a) {
        int n = a.length;
        if (n == 1) return a[0];
        
        int[][] dp = new int[2][n];
        // dp[0][i] -> max money(sum) (0 to i) house if (i-1)th not looted
        // dp[1][i] -> max money(sum) (0 to i) house if (i-1)th looted
        dp[0][0] = 0; dp[1][0] = a[0];

        for (int i=1; i<n; i++) {
            dp[0][i] = dp[1][i-1];
            dp[1][i] = Math.max(dp[0][i-1] + a[i], dp[1][i-1]);
        }

        return Math.max(dp[0][n-1], dp[1][n-1]);

        /*
        int[] dp = new int[n];
        // dp[i] -> max money(sum) (0 to i) house not caring if ith house we looted or not 
        // pick ith -> can not pick last element -> a[i] + dp[i-2]
        // leave ith -> can pick last element -> dp[i-1]
        dp[0] = a[0]; dp[1] = Math.max(a[0], a[1]);

        for(int i=2; i<n; i++){
            dp[i] = Math.max(a[i] + dp[i-2], dp[i-1]);
        }
        return dp[n-1];
        */
    }
}