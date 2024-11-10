class Solution {

    private int val(int[] cnt) {
        int temp = 0;
        for (int i = 0; i < 30; i++) {
            if (cnt[i] != 0) temp ^= 1 << i;
        }
        return temp;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int[] cnt = new int[30];
        int p = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 30; j++) {
                cnt[j] += (nums[i] >> j) & 1;
            }
            while (p <= i && val(cnt) >= k) {
                res = Math.min(res, i - p + 1);
                for (int j = 0; j < 30; j++) {
                    cnt[j] -= (nums[p] >> j) & 1;
                }
                p++;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}