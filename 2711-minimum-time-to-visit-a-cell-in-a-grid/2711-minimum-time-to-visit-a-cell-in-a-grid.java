class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Check if it's impossible to reach the destination from the start
        if (grid[0][1] > 1 && grid[1][0] > 1)
            return -1;

        int[][] time = new int[m + 1][n + 1];
        int[][] vis = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                vis[i][j] = 0;
                time[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0});  // Start from the top-left corner

        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int t = p[0];
            int curx = p[1];
            int cury = p[2];

            // Return time if we reach the bottom-right corner
            if (curx == m - 1 && cury == n - 1) {
                return t;
            }

            if (vis[curx][cury] == 1) continue;
            vis[curx][cury] = 1;

            for (int i = 0; i < 4; i++) {
                int newx = curx + x[i];
                int newy = cury + y[i];

                if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                    int needtime = t + 1;

                    // Adjust time based on grid values
                    if (grid[newx][newy] > t + 1) {
                        int diff = grid[newx][newy] - t;
                        if (diff % 2 == 1)
                            needtime = grid[newx][newy];
                        else
                            needtime = grid[newx][newy] + 1;
                    }

                    if (needtime < time[newx][newy]) {
                        time[newx][newy] = needtime;
                        pq.add(new int[]{needtime, newx, newy});
                    }
                }
            }
        }

        return -1;
    }
}