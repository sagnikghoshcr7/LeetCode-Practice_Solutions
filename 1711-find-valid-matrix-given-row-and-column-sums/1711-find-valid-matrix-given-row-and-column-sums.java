class Solution {
    public int[][] restoreMatrix(int[] row, int[] col) {
        int n = row.length, m = col.length;
        int[][] A = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                A[i][j] = Math.min(row[i], col[j]);
                row[i] -= A[i][j];
                col[j] -= A[i][j];
            }
        }
        return A;
    }
}