class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{firstElement(nums, target), lastElement(nums, target)};
    }

    public int firstElement(int[] a, int k) {
        int lo = -1, hi = a.length;
        while (hi-lo>1) {
            int mid = lo + (hi-lo)/2;
            if (a[mid]<k) lo = mid;
            else hi = mid;
        }
        return hi != a.length && a[hi] == k ? hi : -1;
    }

    public int lastElement(int[] a, int k) {
        int lo = -1, hi = a.length;
        while (hi-lo>1) {
            int mid = lo + (hi-lo)/2;
            if (a[mid]<=k) lo = mid;
            else hi = mid;
        }

        return lo != -1 && a[lo] == k ? lo : -1;
    }
}