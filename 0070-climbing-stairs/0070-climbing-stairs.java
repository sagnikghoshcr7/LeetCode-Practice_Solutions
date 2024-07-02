class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1]; // dp[i] -> distinct ways form 0 to i step
        
        dp[0] = 1; dp[1] = 1;

        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}