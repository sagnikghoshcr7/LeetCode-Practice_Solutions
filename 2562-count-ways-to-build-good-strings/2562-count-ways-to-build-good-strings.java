class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[] = new int[high+1];
        dp[0] = 1;
        int ans = 0; int mod = 1000000007;
        for(int i=1;i<=high;i++){
            dp[i] = ((i-zero>=0 ? dp[i-zero] : 0) + (i-one>=0 ? dp[i-one] : 0))%mod;
            if(i>=low) ans = (ans + dp[i])%mod;
        }
        return ans;
    }    
}