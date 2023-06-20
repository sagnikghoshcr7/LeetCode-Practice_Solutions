class Solution {
    public int[] getAverages(int[] nums, int k) {
        final int n = nums.length;
        final int[] result = new int[n];
        Arrays.fill(result, -1);
        long current = 0;
        for(int i = 0; i < n; i++) {
            current += nums[i];
            if (i - k >= k) {
                result[i - k] = (int)(current / (2 * k + 1));
                current -= nums[i - (2 * k)];
            }
        }
        return result;
    }
}