class Solution {
    public int findPeakElement(int[] A) {
        int n = A.length;
        // Edge Cases
        if (n == 1) return 0;
        if (A[0] >= A[1]) return 0;
        if (A[n - 1] >= A[n - 2]) return n - 1;

        int lo = 1, hi = n - 2;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1]) return mid;
            else if (A[mid] < A[mid - 1]) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }
}