class Solution {
    int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; ++i) {
            String s = Integer.toString(i);
            int t = 0, n = s.length();
            for (int j = 0; j < n / 2; ++j) { 
                t += s.charAt(j) - s.charAt(n - j - 1);
            }
            if (n % 2 == 0 && t == 0)  ans++;
        }
        return ans;
    }
}