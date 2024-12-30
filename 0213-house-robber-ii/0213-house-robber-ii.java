class Solution {
    public int rob(int[] A) {
        if (A.length == 1) return A[0];

        int first = helper(0, A.length-2, A);
        int last = helper(1, A.length-1, A);
        return Math.max(first, last);
    }

    public int helper(int start, int end, int[] A) {
        int n = end - start + 1;
        if (n == 1) return A[start];
        int[] dp = new int[n];

        dp[0] = A[start]; dp[1] = Math.max(A[start], A[start + 1]);

        for (int i=2; i<n; i++) {
            dp[i] = Math.max(A[start + i] + dp[i-2], dp[i-1]);
        }

        return dp[n-1];
    }
}