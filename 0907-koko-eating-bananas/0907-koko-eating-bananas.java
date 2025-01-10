class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 0, hi = maxEle(piles);

        while (hi-lo>1) {
            int mid = lo + (hi-lo)/2;
            if (helper(piles, h, mid)) hi = mid;
            else lo = mid;
        }

        return hi;
    }

    public boolean helper(int[] piles, int h, int k) {
        long hour = 0;
        for (int pile : piles) {
            hour += pile / k;
            if (pile % k != 0) hour++;
        }
        return hour <= h;        
    }

    public int maxEle(int[] a) {
        int max = 0;
        for (int ele : a) max = Math.max(max, ele);
        return max;
    }
}