class Solution {
    public int findMin(int[] a) {
        if (a.length == 1 || a[0] < a[a.length-1]) return a[0];

        int lo = 0, hi = a.length-1;
        while (hi-lo>1) {
            int mid = lo + (hi-lo)/2;
            if (a[mid] > a[hi]) lo = mid;
            else hi = mid;
        }
        return a[hi];
    }
}