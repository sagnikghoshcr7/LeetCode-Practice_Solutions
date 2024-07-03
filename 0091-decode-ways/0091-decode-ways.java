class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1]; // dp[i] -> no. of strings form with digits from index 0 to i 
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i=2; i<=n; i++) {
            int d = s.charAt(i - 1) - '0';
            int dd = 10 * (s.charAt(i - 2) - '0') + (s.charAt(i - 1) - '0');

            if (d >= 1) dp[i] += dp[i - 1];
            if (dd >= 10 && dd <= 26) dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}

// https://youtu.be/np1tSnaYG10