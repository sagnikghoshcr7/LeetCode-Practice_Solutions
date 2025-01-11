class Solution {
    public int search(int[] a, int target) {
        int pivot = findPivot(a);

        int ans = -1;
        ans = bs(a, 0, pivot-1, target);
        if (ans != -1) return ans;
        ans = bs(a, pivot, a.length-1, target);
        return ans;
    }

    public int findPivot(int[] a) {
        int lo = 0, hi = a.length-1;
        while (hi-lo>1) {
            int mid = lo + (hi-lo)/2;
            if (a[mid] > a[hi]) lo = mid;
            else hi = mid;
        }
        return hi;
    }

    public int bs(int[] a, int s, int e, int target) {
        int lo = s-1, hi = e+1;
        while (hi-lo>1) {
            int mid = lo + (hi-lo)/2;
            if (a[mid] < target) lo = mid;
            else hi = mid;
        }

        return (hi >= 0 && hi < a.length && a[hi] == target) ? hi : -1;
    }
}