class Solution {
    private int check(String num, int d1, int d2){
        boolean d2Found = false;
        int n = num.length();
        for(int i=n-1; i>=0; i--){
            int curr = num.charAt(i)-'0';
            if (curr == d2 && d2Found == false) d2Found = true;
            else if (curr == d1 && d2Found == true) return n-(i+2);
        }
        return n;
    }
    public int minimumOperations(String num) {
        int ans = num.length();
        int n = num.length();
        int curr = 0;
        int zCt = 0;
        //check 00
        ans = Math.min(ans, check(num, 0,0));
        //check 25
        ans = Math.min(ans, check(num, 2,5));
        //check 50
        ans = Math.min(ans, check(num, 5,0));
        //check 75
        ans = Math.min(ans, check(num, 7,5));
        
        for(int i=0; i<n; i++){
            curr = num.charAt(i)-'0';
            if (curr == 0) zCt++;
        }
        ans = Math.min(ans, n-zCt);
        return ans;
    }
}