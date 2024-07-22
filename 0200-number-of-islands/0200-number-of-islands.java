class Solution {
    int n, m;
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] adj) {
        if (adj == null || adj.length == 0) return 0;
        n = adj.length; m = adj[0].length;

        boolean[][] vis = new boolean[n][m]; // or visit by setting value as '0'
        int cnt = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!vis[i][j] && adj[i][j] == '1') {
                    bfs(i, j, adj, vis);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }

    private void bfs(int i, int j, char[][] adj, boolean[][] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        vis[i][j] = true;

        while (q.size() > 0) { // !q.isEmpty()
            int[] curr = q.poll();
            for (int[] dir : direction) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if (x>=0 && x<n && y>=0 && y<m) {
                    if (!vis[x][y] && adj[x][y] == '1') {
                        q.offer(new int[] {x, y});
                        vis[x][y] = true;
                    }
                }
            }
        }
    }
}