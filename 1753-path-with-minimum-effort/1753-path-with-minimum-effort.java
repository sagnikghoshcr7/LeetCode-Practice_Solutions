public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, 0, 0});
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int effort = top[0], x = top[1], y = top[2];
            
            if (effort > dist[x][y]) continue;
            
            if (x == rows - 1 && y == cols - 1) return effort;
            
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    int new_effort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (new_effort < dist[nx][ny]) {
                        dist[nx][ny] = new_effort;
                        minHeap.add(new int[]{new_effort, nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}