class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1]; // dp[i] -> min cost till day i

        HashSet<Integer> set = new HashSet<>();
        for (int day : days) set.add(day);

        for (int i = 1; i <= lastDay; i++) {
            if (!set.contains(i)) dp[i] = dp[i - 1];
            else {
                int costDay = dp[i - 1] + costs[0];
                int costWeek = dp[Math.max(0, i - 7)] + costs[1];
                int costMonth = dp[Math.max(0, i - 30)] + costs[2];

                dp[i] = Math.min(costDay, Math.min(costWeek, costMonth));
            }
        }
        return dp[lastDay];
    }
}

// int costDay = Integer.MAX_VALUE, costWeek = Integer.MAX_VALUE, costMonth = Integer.MAX_VALUE;
// if (i>=1) costDay = dp[i-1] + costs[0];
// if (i>=7) costWeek = dp[i-7] + costs[1];
// if (i>=30) costMonth = dp[i-30] + costs[2];