class Solution {
    public int maxDifference(String s) {
        int[] mpp = new int[26];
        int maxi = 0, mini = s.length();
        for (char c : s.toCharArray()) {
            mpp[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (mpp[i] % 2 != 0) {
                maxi = Math.max(maxi, mpp[i]);
            }
            if (mpp[i] % 2 == 0 && mpp[i] > 0) {
                mini = Math.min(mini, mpp[i]);
            }
        }
        return maxi - mini;
    }
}