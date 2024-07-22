// Algo 1 : DFS - Flood Fill  : O(mn) , O(1)
// Marking connected boundary cells and their connecting cells zero
class Solution {
    private int[][] adj; private int n, m;
    public int numEnclaves(int[][] adj) {
        this.adj = adj; this.n = adj.length; this.m = adj[0].length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (i==0 || i==n-1 || j==0 || j==m-1) dfsMakeZero(i, j); // boundary cells
            }
        }

        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (adj[i][j] == 1) cnt++;
            }
        }

        return cnt;
    }

    private void dfsMakeZero(int i, int j) {
        if (isInvalid(i, j)) return;
        if (adj[i][j] == 0) return;
        adj[i][j] = 0;

        dfsMakeZero(i+1, j);
        dfsMakeZero(i-1, j);
        dfsMakeZero(i, j+1);
        dfsMakeZero(i, j-1);
    }

    private boolean isInvalid(int i, int j) {
        return i<0 || j<0 || i>=n || j>=m;
    }
}

/*
// BFS
class Solution {
    public int numEnclaves(int[][] adj) {
        int n = adj.length, m = adj[0].length;

        int[][] vis = new int[n][m]; // can use adj also
        for (int i=0; i<n; i++) vis[i] = adj[i].clone();

        Queue<int[]> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if ((i==0 || i==n-1 || j==0 || j==m-1) && vis[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    vis[i][j] = 0;
                }
            }
        }

        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir: direction) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if (x>=0 && x<n && y>=0 && y<m && vis[x][y] == 1) {
                    q.offer(new int[]{x, y});
                    vis[x][y] = 0;
                }
            }
        }

        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (vis[i][j] == 1) cnt++;
            }
        }

        return cnt;
    }
}
*/