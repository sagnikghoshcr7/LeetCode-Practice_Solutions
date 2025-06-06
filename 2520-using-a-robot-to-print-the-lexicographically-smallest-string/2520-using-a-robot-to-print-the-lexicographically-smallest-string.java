class Solution {
    public String robotWithString(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder t = new StringBuilder();

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char sml = 'a';

        for (char c : s.toCharArray()) {
            if (c == sml) {
                ans.append(c);
            } else {
                t.append(c);
            }

            freq[c - 'a']--;
            while (sml <= 'z' && freq[sml - 'a'] == 0) {
                sml++;
            }

            while (t.length() > 0 && t.charAt(t.length() - 1) <= sml) {
                ans.append(t.charAt(t.length() - 1));
                t.setLength(t.length() - 1);
            }
        }

        while (t.length() > 0) {
            ans.append(t.charAt(t.length() - 1));
            t.setLength(t.length() - 1);
        }

        return ans.toString();
    }
}