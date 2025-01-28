class Solution {
    public int findMaxFish(int [][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0; // variable to store the maximum number of fish caught
        int[] dr = {0, 1, 0, -1}; // array to store the four possible directions
        int[] dc = {1, 0, -1, 0};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] > 0) { // if the current cell contains fish
                    Queue<int[]> q = new LinkedList<>(); // create a queue to perform BFS
                    q.offer(new int[]{i, j}); // add the current cell to the queue
                    int f = grid[i][j]; // count the number of fish caught in the current cell
                    grid[i][j] = 0; // mark the current cell as visited by setting its value to 0
                    while(!q.isEmpty()) { // while there are cells in the queue
                        int[] curr = q.poll(); // remove the first cell from the queue
                        for(int k = 0; k < 4; k++) { // iterate over the four possible directions
                            int nr = curr[0] + dr[k]; // calculate the coordinates of the adjacent cell
                            int nc = curr[1] + dc[k];
                            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] > 0) { // if the adjacent cell contains fish and is within the grid
                                f += grid[nr][nc]; // count the number of fish caught in the adjacent cell
                                grid[nr][nc] = 0; // mark the adjacent cell as visited by setting its value to 0
                                q.offer(new int[]{nr, nc}); // add the adjacent cell to the queue
                            }
                        }
                    }
                    ans = Math.max(ans, f); // update the maximum number of fish caught so far
                }
            }
        }
        return ans; // return the maximum number of fish caught
    }
}