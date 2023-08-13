public class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;

        if (n == 1) return false;

        boolean[] dp = new boolean[]{true, false, n > 1 && nums[0] == nums[1]};

        for (int i = 2; i < n; i++) {
            boolean current_dp = false;

            if (nums[i] == nums[i-1] && dp[1]) {
                current_dp = true;
            }
            else if (nums[i] == nums[i-1] && nums[i] == nums[i-2] && dp[0]) {
                current_dp = true;
            }
            else if (nums[i] - nums[i-1] == 1 && nums[i-1] - nums[i-2] == 1 && dp[0]) {
                current_dp = true;
            }

            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = current_dp;
        }

        return dp[2];
    }
}