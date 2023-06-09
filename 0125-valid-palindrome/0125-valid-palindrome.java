class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(""), rev = new StringBuilder("");

        for (int i=0; i<s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
                rev.insert(0, s.charAt(i));
            }
        }
        return sb.toString().equalsIgnoreCase(rev.toString());
    }
}