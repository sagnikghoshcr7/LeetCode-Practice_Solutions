class Solution {
    public int maxScore(String s) {
        int countOne = 0, n = s.length();
        char[] chars = s.toCharArray();

        for(int i=0; i<n; i++){
            if(chars[i]=='1') countOne++;
        }

        int leftScore = 0, rightScore = 0, result = 0, leftOne = 0;

        for(int i=0; i<n-1; i++){
            if (chars[i] == '1') leftOne++;
            else leftScore++;
            rightScore= countOne - leftOne;
            result = Math.max(result, leftScore + rightScore);
        }
        return result;
    }
}