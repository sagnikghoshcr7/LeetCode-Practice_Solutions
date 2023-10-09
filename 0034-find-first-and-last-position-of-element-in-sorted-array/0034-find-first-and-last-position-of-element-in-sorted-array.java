class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};
        return new int[]{first(nums, target), last(nums, target)};
    }

    public int first(int[] a, int target) {
        int l = 0, r = a.length - 1;

        while(l <= r) {
            int mid = l + (r-l)/2;
            if (a[mid] == target && (mid == 0 || a[mid-1] < target)) return mid;
            else if (a[mid] >= target) r = mid-1;
            else l = mid+1;
        }
        return -1;
    }

    public int last(int[] a, int target) {
        int l=0, r = a.length-1;

        while (l <= r) {
            int mid = l + (r-l)/2;
            if (a[mid] == target && (mid == a.length-1 || a[mid+1]>target)) return mid;
            else if (a[mid] <= target) l = mid+1;
            else r = mid-1;
        }
        return -1;
    }
}