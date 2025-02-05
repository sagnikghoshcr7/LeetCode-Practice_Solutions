class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) l.add(i);
			if (l.size() > 2) return false; // added this line to short circuit the loop
        }
        return l.size() == 0 || (l.size() == 2
                                 && s1.charAt(l.get(0)) == s2.charAt(l.get(1))
                                 && s1.charAt(l.get(1)) == s2.charAt(l.get(0)));
    }
}