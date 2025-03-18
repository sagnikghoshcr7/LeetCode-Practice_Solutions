class Solution {
    public int longestNiceSubarray(int[] nums) {
        int used = 0, j = 0, res = 0;
        for (int i = 0; i < nums.length; ++i) {
            while ((used & nums[i]) != 0)
                used ^= nums[j++];
            used |= nums[i];
            res = Math.max(res, i - j + 1);
        }
        return res;    
    }
}