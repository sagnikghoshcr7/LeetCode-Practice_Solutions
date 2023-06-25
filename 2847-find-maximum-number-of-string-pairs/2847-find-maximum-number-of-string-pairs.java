class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int n = words.length, count = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (new StringBuilder(words[i]).reverse().toString().equals(words[j])) count++;
            }
        }
        return count;
    }
}