class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        Queue<int[]> bfs = new LinkedList<>();
        int[][] height = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (isWater[r][c] == 1) {
                    height[r][c] = 0;
                    bfs.offer(new int[]{r, c});
                } else {
                    height[r][c] = -1;
                }
            }
        }
        int[] DIR = new int[]{0, 1, 0, -1, 0};
        while (!bfs.isEmpty()) {
            int[] top = bfs.poll();
            int r = top[0], c = top[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + DIR[i], nc = c + DIR[i+1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || height[nr][nc] != -1) continue;
                height[nr][nc] = height[r][c] + 1;
                bfs.offer(new int[]{nr, nc});
            }
        }
        return height;
    }
}