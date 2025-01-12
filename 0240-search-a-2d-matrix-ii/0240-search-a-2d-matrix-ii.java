public class Solution {
    public boolean searchMatrix(int[][] a, int k) {
        if(a == null || a.length < 1 || a[0].length <1) return false;

        int m = 0, n = a[0].length-1;

        while(n >= 0 && m <= a.length-1) {
            if(k == a[m][n]) return true;
            else if(k > a[m][n]) m++;
            else if(k < a[m][n]) n--;
        }
        return false;
    }
}