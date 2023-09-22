class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.equals(t)) return true;
        if (s.isEmpty()) return true;
        if (t.isEmpty() && !s.isEmpty()) return false;
        
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        int sPoint = 0;
        int tPoint = 0;
        
        while (sPoint < sChars.length && tPoint < tChars.length) {
            if (tChars[tPoint]  == sChars[sPoint]) {
                sPoint++;
                tPoint++;
                continue;
            }
            
            if (tChars[tPoint] != sChars[sPoint]) {
                tPoint++;
                continue;
            }
        }
        
        if (sPoint != sChars.length) return false;
        
        return true;
    }
}