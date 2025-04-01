class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];	
        
        for(int i = n - 1; i >= 0; i--){
            dp[i] = Math.max(questions[i][0] + dp[Math.min(n, i + questions[i][1] + 1)], dp[i + 1]);
        }

        return dp[0];
    }
}