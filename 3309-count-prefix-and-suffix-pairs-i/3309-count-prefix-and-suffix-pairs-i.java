class Solution {
    private boolean isPrefixAndSuffix(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        if (n1 > n2) {
            return false;
        }
        return str2.substring(0, n1).equals(str1) && str2.substring(n2 - n1).equals(str1);
    }

    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length, count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}