class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0, len = 0, max = 0;
        for (int ele : nums) {
            max = Math.max(max, ele);
        }

        for (int ele : nums) {
            if (ele == max) res = Math.max(res, ++len);
            else len = 0;
        }
        return res;
    }
}