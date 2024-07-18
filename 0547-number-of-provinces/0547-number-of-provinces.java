class Solution {
    int n;
    public int findCircleNum(int[][] adj) {
        n = adj.length;
        boolean[] vis = new boolean[n];
        int cnt = 0;

        for (int i=0; i<n; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                cnt++;
            }
        }

        return cnt;
    }

    private void dfs(int node, int[][] adj, boolean[] vis) {
        vis[node] = true;
        for (int i=0; i<n; i++) {
            if (adj[node][i] == 1 && !vis[i]) dfs(i, adj, vis);
        }
    }
}