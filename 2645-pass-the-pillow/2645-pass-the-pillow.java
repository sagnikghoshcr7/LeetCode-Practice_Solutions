class Solution {
    public int passThePillow(int n, int time) {
        time = time % ((n - 1) * 2) + 1;
        return Math.min(time, n * 2 - time);
    }
}