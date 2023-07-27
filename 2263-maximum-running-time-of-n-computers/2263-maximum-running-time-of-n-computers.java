public class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sumPower = 0;
        for (int power : batteries) sumPower += power;
        long left = 1, right = sumPower / n;
        
        while (left < right){
            long time = (left+right+1) / 2;
            if (check(batteries, n, time)) left = time;
            else right = time - 1;
        }
        return left;
    }
    
    public boolean check(int [] B, int n, long time){
        long sum = 0;
        for(int battery: B) {
            sum+=Math.min(battery, time);
        }
        return (sum>=(long)time*n);
    }
}