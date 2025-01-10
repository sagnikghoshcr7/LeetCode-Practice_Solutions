class Solution {
    public int findKthPositive(int[] a, int k) {
        int lo = -1, hi = a.length;
        while (hi-lo>1) {
            int mid = lo + (hi-lo)/2;
            if (a[mid] - mid - 1 >= k) hi = mid;
            else lo = mid;
        }

        return hi + k;
    }
}