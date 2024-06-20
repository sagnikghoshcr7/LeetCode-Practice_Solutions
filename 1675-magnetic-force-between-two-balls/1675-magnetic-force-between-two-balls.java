class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1, hi = (position[position.length-1]-position[0])/(m-1), ans = 1;
        while (lo <= hi) {
            int mid = lo+(hi-lo)/2;
            if (canWePlace(position, mid, m)) {
                ans = mid;
                lo=mid+1;
            }
            else hi = mid-1;
        }
        return ans;
    }
    private boolean canWePlace(int[] arr, int dist, int cows) {
        int cntCows = 1, last = arr[0];
        for(int i=0; i<arr.length; i++) {
            if (arr[i]-last >= dist) {
                cntCows++;
                last = arr[i];
            }
            if (cntCows >= cows) return true;
        }
        return false;
    }
}