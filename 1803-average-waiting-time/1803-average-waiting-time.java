class Solution {
    public double averageWaitingTime(int[][] A) {
        double wait = 0, cur = 0;
        for (int[] a: A) {
            cur = Math.max(cur, 1.0 * a[0]) + a[1];
            wait += cur - a[0];
        }
        return 1.0 * wait / A.length;
    }
}