class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int leftBound = -1, jmin = -1, jmax = -1;
        for(int i = 0; i < nums.length;++i) {
            if(nums[i] < minK || nums[i] > maxK)    leftBound = i;
            if(nums[i] == minK) jmin = i;
            if(nums[i] == maxK) jmax = i;
            ans += Math.max(0, Math.min(jmax , jmin) - leftBound);
        }
        return ans;
    }
}