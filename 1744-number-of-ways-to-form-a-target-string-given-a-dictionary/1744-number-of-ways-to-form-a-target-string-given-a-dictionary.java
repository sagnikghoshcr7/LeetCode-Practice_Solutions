class Solution {
    String[] words;
    String target;
    Integer[][] memo;
    int m, n;
    int[][] charAtIndexCnt;
    public int numWays(String[] words, String target) {
        this.words = words; this.target = target;
        m = words[0].length(); n = target.length();
        memo = new Integer[m][n];
        charAtIndexCnt = new int[128][m];
        
        for (String word : words)
            for (int i = 0; i < word.length(); i++)
                charAtIndexCnt[word.charAt(i)][i] += 1; // Count the number of character `c` at index `i` of all words
        return dp(0, 0);
    }
    
    int dp(int k, int i) {
        if (i == n)  // Formed a valid target
            return 1;
        if (k == m)  // Reached to length of words[x] but don't found any result
            return 0;
        if (memo[k][i] != null) return memo[k][i];
        char c = target.charAt(i);
        long ans = dp(k + 1, i);  // Skip k_th index of words
        if (charAtIndexCnt[c][k] > 0) { // Take k_th index of words if found character `c` at index k_th
            ans += (long) dp(k + 1, i + 1) * charAtIndexCnt[c][k];
            ans %= 1_000_000_007;
        }
        return memo[k][i] = (int) ans;
    }
}