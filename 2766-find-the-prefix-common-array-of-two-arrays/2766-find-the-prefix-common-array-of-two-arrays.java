class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n],cnt = new int[51];
        for (int i = 0; i < n; ++i) {
            res[i] = (++cnt[A[i]] == 2 ? 1 : 0) + (++cnt[B[i]] == 2 ? 1 : 0);
            if(i > 0)  res[i] += res[i - 1];
        }
        return res;
    }
}