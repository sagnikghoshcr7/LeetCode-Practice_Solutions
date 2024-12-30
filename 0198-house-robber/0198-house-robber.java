class Solution {
    public int rob(int[] A) {
        int n = A.length;
        if (n == 1) return A[0];
        int[] dp = new int[n];

        dp[0] = A[0]; dp[1] = Math.max(A[0], A[1]);

        for (int i=2; i<n; i++) {
            dp[i] = Math.max(A[i] + dp[i-2], dp[i-1]);
        }

        return dp[n-1];
    }
}