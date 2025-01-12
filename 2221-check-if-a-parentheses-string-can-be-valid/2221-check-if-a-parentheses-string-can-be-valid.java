class Solution {
    public boolean canBeValid(String s, String l) {
        if (s.length() % 2 == 1) return false;
        int total = 0, open = 0, closed = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if (l.charAt(i) == '0') total += 1;
            else if (s.charAt(i) == '(') open += 1;
            else if (s.charAt(i) == ')') closed += 1;
            if (total - open + closed < 0) return false;
        }
        
        total = open = closed = 0;
        for(int i = 0; i < s.length(); i++) {
            if (l.charAt(i) == '0') total += 1;
            else if (s.charAt(i) == '(') open += 1;
            else if (s.charAt(i) == ')') closed += 1;
            if (total + open - closed < 0) return false;
        }
        return true;
    }
}