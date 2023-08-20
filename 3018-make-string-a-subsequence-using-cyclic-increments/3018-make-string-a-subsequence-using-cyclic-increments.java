class Solution {
    public boolean canMakeSubsequence(String s1, String s2) {
        int i=0, j=0;

        while (i<s1.length() && j<s2.length()) {
            int req = s2.charAt(j)-'a';
            int curr = s1.charAt(i)-'a';
            if (req == curr || req == (curr+1)%26) j++;
            i++;
        }

        return j == s2.length();
    }
}