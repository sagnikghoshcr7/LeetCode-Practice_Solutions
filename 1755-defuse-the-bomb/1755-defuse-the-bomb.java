class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ret = new int[n];
        if(k == 0){
            Arrays.fill(ret,0);
            return ret;
        }
        int[] temp = new int[2*n];
        for(int i = 0; i < n; i ++){
            temp[i] = code[i];
            temp[i+n] = code[i];
        }
        int[] pref = new int[temp.length+1];
        for(int i = 1; i <= temp.length; i ++){
            pref[i] = temp[i-1]+pref[i-1];
        }
        for(int i = 0; i < n; i ++){
            if(k > 0)
                ret[i] = pref[i+k+1]-pref[i+1];
            if(k < 0)
                ret[i] = pref[i+n]-pref[i+k+n];
        }
        return ret;
    }
}