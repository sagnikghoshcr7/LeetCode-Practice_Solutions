class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        
        for (char[] row : box) {
            int dropPos = n - 1;
            
            for (int currPos = n - 1; currPos >= 0; currPos--) {
                if (row[currPos] == '*') {
                    dropPos = currPos - 1;
                }
                else if (row[currPos] == '#') {
                    char temp = row[dropPos];
                    row[dropPos] = row[currPos];
                    row[currPos] = temp;
                    dropPos--;
                }
            }
        }
        
        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - 1 - i] = box[i][j];
            }
        }
        
        return rotatedBox;
    }
}