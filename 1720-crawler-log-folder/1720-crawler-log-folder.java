class Solution {
    public int minOperations(String[] logs) {
        int level = 0;
        for (String s : logs) {
            if (s.charAt(1) == '.') level = Math.max(0, level-1);
            else if (s.charAt(0) != '.') level++;
        }
        return level;
    }
}