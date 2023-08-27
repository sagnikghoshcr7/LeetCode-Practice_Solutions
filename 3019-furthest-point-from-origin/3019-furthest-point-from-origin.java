class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int cntL = 0, cntR = 0, cnt_ = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'L') cntL++;
            if (ch == 'R') cntR++;
            if (ch == '_') cnt_++;
        }
        return Math.max(cntL, cntR) - Math.min(cntL, cntR) + cnt_;
    }
}