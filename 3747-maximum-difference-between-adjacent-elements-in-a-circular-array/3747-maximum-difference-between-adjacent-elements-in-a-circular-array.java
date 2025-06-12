class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxa = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 0; i < n - 1; i++) {
            maxa = Math.max(maxa, Math.abs(nums[i] - nums[i + 1]));
        }
        return maxa;
    }
}