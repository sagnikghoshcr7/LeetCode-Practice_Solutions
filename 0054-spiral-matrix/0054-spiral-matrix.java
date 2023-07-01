class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int count = 0;
        List<Integer> res = new ArrayList<Integer>();
        int frow = 0, fcol = 0, lrow = n-1, lcol = m-1;

        while (count < m*n) {
            // printing 1st row
            for (int i=fcol; i<=lcol && count < m*n; i++) {
                res.add(arr[frow][i]);
                count++;
            }
            frow++;
    
            // printing last col
            for (int i=frow; i<=lrow && count < m*n; i++) {
                res.add(arr[i][lcol]);
                count++;
            }
            lcol--;

            // printing last row
            for (int i=lcol; i>=fcol && count < m*n; i--) {
                res.add(arr[lrow][i]);
                count++;
            }
            lrow--;

            // printing 1st col
            for (int i=lrow; i>= frow && count < m*n; i--) {
                res.add(arr[i][fcol]);
                count++;
            }
            fcol++;
        }
        return res;
    }
}