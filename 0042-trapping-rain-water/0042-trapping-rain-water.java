class Solution {
    public int trap(int[] A) {
        int n = A.length;
        if (n == 1) return 0;

        int[] pf = new int[n]; int[] sf = new int[n];

        int max = pf[0];
        for (int i=0; i<n; i++) {max = Math.max(A[i], max); pf[i] = Math.max(pf[i], max);}

        max = sf[n-1];
        for (int i=n-1; i>=0; i--) {max = Math.max(A[i], max); sf[i] = Math.max(sf[i], max);}

        int res = 0;
        for (int i=0; i<n; i++) res += (Math.min(pf[i], sf[i]) - A[i]);

        return res;
    }
}