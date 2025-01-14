class Solution {
    public boolean canJump(int[] a) {
        int n = a.length;
        int maxReach = 0;

        for (int i=0; i<n-1; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + a[i]);
        }

        return maxReach >= n-1;
    }
}