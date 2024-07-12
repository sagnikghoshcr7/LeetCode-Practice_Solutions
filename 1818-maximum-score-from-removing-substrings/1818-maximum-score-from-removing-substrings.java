class Solution {
    private int removePairs(StringBuilder s, String target) {
        int write_ind = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            s.setCharAt(write_ind, s.charAt(i));
            write_ind++;
            if (write_ind >= 2 && s.charAt(write_ind - 1) == target.charAt(1) && s.charAt(write_ind - 2) == target.charAt(0)) {
                count++;
                write_ind -= 2;
            }
        }
        s.setLength(write_ind);
        return count;
    }

    public int maximumGain(String s, int x, int y) {
        int res = 0;
        StringBuilder sb = new StringBuilder(s);
        String top, bot;
        int top_score, bot_score;

        if (y > x) {
            top = "ba";
            top_score = y;
            bot = "ab";
            bot_score = x;
        } else {
            top = "ab";
            top_score = x;
            bot = "ba";
            bot_score = y;
        }

        res += removePairs(sb, top) * top_score;
        res += removePairs(sb, bot) * bot_score;
        return res;
    }
}