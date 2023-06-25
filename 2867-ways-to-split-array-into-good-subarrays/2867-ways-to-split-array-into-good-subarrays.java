class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        long ans = 0;
        int currZeroCt = 0;
        int oneCt = 0;
        int n = nums.length;
        int mod = 1000000007;
        for(int i=0;i<n;i++){
            if(nums[i]==0) currZeroCt++;
            else {
                oneCt++;
                if (oneCt==1) ans = 1;
                else ans = (ans * (currZeroCt+1)%mod)%mod;
                
                currZeroCt = 0;
            }
        }
        return (int)ans;
    }
}