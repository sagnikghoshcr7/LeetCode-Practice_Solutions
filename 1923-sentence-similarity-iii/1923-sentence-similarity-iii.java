class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        String[] words1 = s1.split(" "), words2 = s2.split(" ");
        int i = 0, n1 = words1.length, n2 = words2.length;
        if (n1 > n2) {
            return areSentencesSimilar(s2, s1);
        }
        while (i < n1 && words1[i].equals(words2[i])) {
            ++i;
        }
        while (i < n1 && words1[i].equals(words2[n2 - n1 + i])) {
            ++i;
        }
        return i == n1;
    }
}