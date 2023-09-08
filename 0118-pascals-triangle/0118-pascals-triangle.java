class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> pascal = new ArrayList<>();
        List<Integer> first = new ArrayList<>();

        int[][] dp = new int[n][n + 1];
        dp[0][1]=1; first.add(dp[0][1]);
        pascal.add(first);

        for(int i=1; i<n; i++) {
            List<Integer> internal = new ArrayList<>();
            for(int j=1; j<=i+1; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                internal.add(dp[i][j]);
            }
            pascal.add(internal); 
        }
        
        return pascal;
    }
}