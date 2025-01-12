class Solution {
    public boolean search(int[] a, int target) {
        int pivot = findPivot(a);

        return bs(a, 0, pivot-1, target) || bs(a, pivot, a.length-1, target);
    }

    public int findPivot(int[] a) {
        int lo = 0, hi = a.length-1;

        while (hi-lo>1) {
            while(hi-lo>1 && a[lo] == a[lo+1]) lo++;
            while(hi-lo>1 && a[hi] == a[hi-1]) hi--;

            int mid = lo + (hi-lo)/2;
            if (a[mid] > a[hi]) lo = mid;
            else hi = mid;
        }
        return hi;
    }

    public boolean bs(int[] a, int s, int e, int target) {
        int lo = s-1, hi = e+1;
        while (hi-lo>1) {
            int mid = lo + (hi-lo)/2;
            if (a[mid] < target) lo = mid;
            else hi = mid;
        }

        return (hi >= 0 && hi < a.length && a[hi] == target) ? true : false;
    }
}