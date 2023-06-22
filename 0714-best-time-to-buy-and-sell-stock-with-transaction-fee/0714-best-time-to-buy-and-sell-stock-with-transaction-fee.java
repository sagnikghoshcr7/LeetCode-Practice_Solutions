class Solution {
    public int maxProfit(int[] prices, int fee) {
        int m = prices.length;
        int[] dp = new int[2];

        for(int i = m - 1; i >= 0; i--){
            int[] curr = new int[2];
            for(int k = 0; k <= 1; k++){
                //doNothing
                int doNothing = dp[k];

                //buy sell
                int buysell = 0;

                if(k == 0) buysell = -prices[i] + dp[1];
                else buysell = prices[i] - fee + dp[0];

                curr[k] = Math.max(doNothing, buysell);
            }

            dp = curr;
        }

        return dp[0];
    }
}