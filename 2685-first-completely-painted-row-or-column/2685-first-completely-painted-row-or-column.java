class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> colMap = new HashMap<>();
        
        for (int j = 0; j < mat.length; j++) {
            for (int k = 0; k < mat[0].length; k++) {
                 rowMap.put(mat[j][k], j);
                colMap.put(mat[j][k], k);
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            int j = rowMap.get(arr[i]);
            int k = colMap.get(arr[i]);
            rows[j]++;
            cols[k]++;
            if (rows[j] == mat[0].length || cols[k] == mat.length) return i;
        }
        return 0;
    }
}