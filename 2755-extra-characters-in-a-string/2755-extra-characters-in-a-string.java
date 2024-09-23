class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>();

        for (String word : dictionary) dict.add(word);

        int n = s.length();

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            for (int j = i; j >= 1; j--) {
                String sub = s.substring(j - 1, i);

                if (dict.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
            }
        }

        return dp[n];        
    }
}