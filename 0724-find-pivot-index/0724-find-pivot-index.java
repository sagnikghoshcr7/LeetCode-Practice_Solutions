class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = nums[0]; suff[n-1] = nums[n-1];
        for (int i=1; i<n; i++) pref[i] = nums[i] + pref[i-1];
        for (int i=n-2; i>=0; i--) suff[i] = nums[i] + suff[i+1];

        for (int i=0; i<n; i++) if (pref[i] == suff[i]) return i;
        return -1;
    }
}