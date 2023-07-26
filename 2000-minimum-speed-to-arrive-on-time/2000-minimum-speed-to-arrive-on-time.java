class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int lo = 1, hi = 10000000, ans = -1;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(isPossible(dist, mid, hour)){
                ans = mid;
                hi = mid - 1;
            }
            else lo = mid + 1;
        }
        return ans;
    }


    private boolean isPossible(int[] dist, int speed, double hour) {
        double time = 0.0;
        for(int i = 0; i < dist.length; i++) {
            time += (i != dist.length - 1) ? Math.ceil((double)dist[i] / speed): ((double)dist[i] / speed);
        }
        return time <= hour;
    }
}