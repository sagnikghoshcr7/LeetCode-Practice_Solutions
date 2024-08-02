class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0, x = 0, onesInWindow = 0, i = 0, n = nums.length;
        for (int v: nums)
            if (v == 1) ones++;
        int nums2[] = new int[n * 2];
        for (i = 0; i < n * 2; i++)
            nums2[i] = nums[i % n];
        for (i = 0; i < n * 2; i++) {
            if (i >= ones && nums2[i - ones] == 1) x--;
            if (nums2[i] == 1) x++;
            onesInWindow = Math.max(x, onesInWindow);
        }
        return ones - onesInWindow;
    }
}