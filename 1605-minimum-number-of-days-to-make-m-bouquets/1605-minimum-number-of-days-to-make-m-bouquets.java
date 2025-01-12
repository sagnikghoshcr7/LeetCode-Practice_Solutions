class Solution {
    public int minDays(int[] a, int m, int k) {
        if ((long) m*k > a.length) return -1;
        int lo = 0, hi = maxEle(a);
        while (hi-lo>1) {
            int mid = lo + (hi-lo)/2;
            if (helper(a, m, k, mid)) hi = mid;
            else lo = mid;
        }

        return hi;
    }

    public boolean helper(int[] a, int m, int k, int mid) {
        int bokey = 0, count = 0;

        for (int i=0; i<a.length; i++) {
            if (a[i] <= mid) count++;
            else count = 0;

            if (count == k) {
                bokey++;
                count = 0;
            }
        }

        return bokey >= m;
    }

    public int maxEle(int[] a) {
        int max = 0;
        for (int ele : a) max = Math.max(max, ele);
        return max;
    }
}