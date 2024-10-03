class Solution {
    public int minSubarray(int[] A, int p) {
        int n = A.length, res = n, need = 0, cur = 0;
        for (int a : A)
            need = (need + a) % p;
        Map<Integer, Integer> last = new HashMap<>();
        last.put(0, -1);
        for (int i = 0; i < n; ++i) {
            cur = (cur + A[i]) % p;
            last.put(cur, i);
            int want = (cur - need + p) % p;
            res = Math.min(res, i - last.getOrDefault(want, -n));
        }
        return res < n ? res : -1;
    }
}