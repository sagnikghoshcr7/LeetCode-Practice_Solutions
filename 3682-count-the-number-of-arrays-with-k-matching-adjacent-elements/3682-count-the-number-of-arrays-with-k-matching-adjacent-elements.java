class Solution {
    static final int MOD = 1_000_000_007;

    long modInverse(long a, long mod) {
        long res = 1;
        long power = mod - 2;

        while (power > 0) {
            if ((power & 1) == 1)
                res = res * a % mod;
            a = a * a % mod;
            power >>= 1;
        }

        return res;
    }

    int nCr(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;

        long res = 1;

        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) % MOD;
            res = res * modInverse(i, MOD) % MOD;
        }

        return (int)res;
    }

    long binExpo(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                result = result * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return result;
    }

    public int countGoodArrays(int n, int m, int k) {
        long formula = m * binExpo(m - 1, n - (k + 1)) % MOD;
        long updatedFormula = formula * nCr(n - 1, k) % MOD;
        return (int)updatedFormula;
    }
}
