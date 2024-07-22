class Solution {
    int[][] adj;
    boolean[][] vis;
    int n, m;

    public int maxAreaOfIsland(int[][] adj) {
        this.adj = adj; n = adj.length; m = adj[0].length; vis = new boolean[n][m];
        int ans = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }

        return ans;
    }

    private int dfs(int i, int j) {
        if (i<0 || i>=n || j<0 || j>=m || vis[i][j] || adj[i][j] == 0) return 0;
        vis[i][j] = true;
        return (1 + dfs(i+1, j) + dfs(i-1, j) + dfs(i, j+1) + dfs(i, j-1));
    }
}