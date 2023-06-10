class Solution {
    public int matrixSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[] A = new int[m];
        for (int i=0; i<m; i++) {
            Arrays.sort(nums[i]);
        }
        int sum = 0;
        for (int j=0; j<n; j++) {
            int max = Integer.MIN_VALUE;
            for (int i=0; i<m; i++) {
                if (nums[i][j] > max) max = nums[i][j];
            }
            sum += max;
        }
        return sum;        
    }
}