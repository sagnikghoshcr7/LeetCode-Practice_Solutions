class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 0, hi = maxEle(nums);
        while (hi-lo>1) {
            int mid = lo + (hi-lo)/2;
            if (helper(nums, threshold, mid)) hi = mid;
            else lo = mid;
        }

        return hi;
    }

    public boolean helper(int[] a, int k, int mid) {
        int sum = 0;
        for (int i=0; i<a.length; i++) {
            sum += a[i]/mid;
            if (a[i]%mid != 0) sum++;
        }
        return sum <= k;
    }

    public int maxEle(int[] a) {
        int max = 0;
        for (int ele : a) max = Math.max(max, ele);
        return max;
    }
}