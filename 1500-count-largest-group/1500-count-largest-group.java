class Solution {
    public int countLargestGroup(int n) {
        int ans = 0;
        int[] dp = new int[n + 1];
        int[] counts = new int[37]; // max sum of digits of n <= 10000 is 36 (sum of digits of 9999)
        for (int i = 1; i <= n; i++) {
            dp[i] = i % 10 + dp[i / 10];
            counts[dp[i]]++;
        }
        int max = 0;
        for (int count : counts)
            max = Math.max(max, count);
        for (int count : counts) {
            if (count == max)
                ans++;
        }
        return ans;
    }
}