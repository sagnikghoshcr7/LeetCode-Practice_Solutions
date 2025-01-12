class Solution {
    public boolean searchMatrix(int[][] a, int k) {
        int m = a.length, n = a[0].length;
        int lo = 0, hi = (m * n) - 1;

        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;

            if (a[mid / n][mid % n] == k) return true;
            else if (a[mid / n][mid % n] < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}

// TC : log(m*n)