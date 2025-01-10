class Solution {
    public int shipWithinDays(int[] a, int d) {
        int lo = 0, hi = sumEle(a);

        while (hi-lo>1) {
            int mid = lo + (hi-lo)/2;
            if (helper(a, d, mid)) hi = mid;
            else lo = mid;
        }

        return hi;        
    }

    public boolean helper(int[] a, int d, int mid) {
        int day = 1, restWeight = mid;
        for (int i=0; i<a.length; i++) {
            if (a[i] > mid) return false;
            if (a[i] > restWeight) {
                day++; restWeight = mid; i--; continue;
            }
            else restWeight -= a[i];            
        }

        return day <= d;
    }

    public int sumEle(int[] a) {
        int sum = 0;
        for (int ele : a) sum += ele;
        return sum;
    }
}