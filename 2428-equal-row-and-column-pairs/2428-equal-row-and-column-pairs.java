class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> cnt = new HashMap<>();
        for (int[] row : grid) {
            cnt.merge(Arrays.toString(row), 1, Integer::sum);
        }
        int pairs = 0;
        for (int c = 0, n = grid.length; c < n; ++c) {
            int[] col = new int[n];
            for (int r = 0; r < n; ++r) {
                col[r] = grid[r][c];
            }
            pairs += cnt.getOrDefault(Arrays.toString(col), 0);
        }
        return pairs;
    }
}