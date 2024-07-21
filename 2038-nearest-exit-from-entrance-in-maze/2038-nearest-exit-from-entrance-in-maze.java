class Solution {
    public int nearestExit(char[][] adj, int[] entry) {
        int n = adj.length, m = adj[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(entry);
        adj[entry[0]][entry[1]] = '+';

        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int steps = 0;
        int x, y;

        while (!q.isEmpty()) {
            steps++;
            int k = q.size();
            for (int i=0; i<k; i++) {
                int[] curr = q.poll();

                for (int[] dir : directions) {
                    x = curr[0] + dir[0];
                    y = curr[1] + dir[1];

                    if (x<0 || x>=n || y<0 || y>=m || adj[x][y] == '+') continue;
                    if (x == 0 || x == n-1 || y == 0 || y == m-1) return steps;

                    adj[x][y] = '+';
                    q.offer(new int[]{x, y});
                }
            }
        }
        return -1;        
    }
}