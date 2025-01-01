class Solution {
    public int lengthOfLIS(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Each element is at least an LIS of length 1

        for (int i=1; i<n; i++) {
            for (int j=0; j<=i; j++) {
                if (A[i] > A[j]) dp[i] = Math.max(dp[i], 1+dp[j]);
            }
        }

        int ans = 0;
        for (int i : dp) ans = Math.max(ans, i);

        return ans;
    }
}