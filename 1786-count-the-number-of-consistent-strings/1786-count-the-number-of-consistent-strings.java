class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] map = new boolean[26];
        for (char c : allowed.toCharArray()) {
            map[c - 'a'] = true;
        }
        int ans = 0;
        for (String word : words) {
            int i = 0;
            int len = word.length();
            while (i < len) {
                if (!map[word.charAt(i) - 'a']) break;
                i += 1;
            }
            ans += (i == len ? 1 : 0);
        }
        return ans;
    }
}