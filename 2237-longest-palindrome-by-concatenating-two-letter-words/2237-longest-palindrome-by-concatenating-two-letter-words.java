class Solution {
    public int longestPalindrome(String[] words) {
        int counter[][] = new int[26][26];
        int ans = 0;
        for (String w: words) {
            int a = w.charAt(0) - 'a', b = w.charAt(1) - 'a';
            if (counter[b][a] > 0) {
                ans += 4; 
                counter[b][a]--; 
            }
            else counter[a][b]++;
        }
        for (int i = 0; i < 26; i++) {
            if (counter[i][i] > 0) {
                ans += 2;
                break;
            }
        }
        return ans;
    }
}