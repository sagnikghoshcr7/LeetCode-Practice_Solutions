class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        long zeroCnt = 0, ans = 0;
        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) == '0') zeroCnt++;
            else ans += zeroCnt;
        }

        return ans;
    }
}