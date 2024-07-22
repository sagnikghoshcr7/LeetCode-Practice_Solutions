class Solution {
    int n, m;
    public int closedIsland(int[][] adj) {
        n = adj.length; m = adj[0].length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (adj[i][j] == 0 && dfs(adj,i, j)) count++;
            }
        }
        
        return count;
    }
    public boolean dfs(int[][] adj,int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m) return false;
        if (adj[i][j] == 1) return true;
        adj[i][j] = 1; // mark as visited
        boolean left = dfs(adj,i, j-1), right = dfs(adj,i, j+1);
        boolean up = dfs(adj,i-1, j), down = dfs(adj,i+1, j);
        return left && right && up && down;
    }
}
