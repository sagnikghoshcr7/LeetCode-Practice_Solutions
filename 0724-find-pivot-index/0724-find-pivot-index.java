class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int lsum = 0, rsum = 0;
        for (int i : nums) rsum += i;
        for (int i=0; i<n; i++) {
            lsum += nums[i];
            if (lsum == rsum) return i;
            rsum -= nums[i];
        }
        return -1;
    }
}