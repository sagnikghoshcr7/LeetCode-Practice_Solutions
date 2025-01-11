class Solution {
    public int splitArray(int[] a, int k) {
        int lo = min(a), hi = sum(a), n = a.length;

        while (hi-lo>1) {
            int mid = lo + (hi-lo)/2;
            if (check(a, n, k, mid)) hi = mid;
            else lo = mid;
        }

        return hi;
    }

    public boolean check(int[] a, int n, int k, int mid) {
        int split=1, i=0, restSum = mid;
        while (i<n) {
            if (a[i] > mid) return false;
            if (a[i] > restSum) {
                split++;
                restSum = mid;
            }
            else {
                restSum -= a[i];
                i++;
            }
        }

        return split <= k;
    }

    public int min(int[] a) {
        int ans = Integer.MAX_VALUE;
        for (int i: a) ans = Math.min(ans, i);
        return ans;
    }

    public int sum(int[] a) {
        int ans = 0;
        for (int i: a) ans += i;
        return ans;
    }
}