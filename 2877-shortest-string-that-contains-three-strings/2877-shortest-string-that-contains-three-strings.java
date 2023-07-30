class Solution {
    String ans = "";
    private String merge(String a, String b){
        if(a.contains(b)) return a;

        for(int i=Math.min(a.length(), b.length());i>=0;i--){
            if(a.substring(a.length()-i).equals(b.substring(0,i))){
                return a+b.substring(i);
            }
        }
        return a + b;
    }

    private String getSmallerString(String a, String b){
        if(a.length() == b.length()){
            if(a.compareTo(b)<0) return a;
            return b;
        }
        return a.length() < b.length() ? a : b;
    }

    private void updateAnsForCurrentComb(String a, String b, String c){
        String x = merge(merge(a,b),c);
        ans = getSmallerString(ans, x);
    }

    public String minimumString(String a, String b, String c) {
        ans = a+b+c;
        updateAnsForCurrentComb(a,b,c);
        updateAnsForCurrentComb(a,c,b);
        updateAnsForCurrentComb(b,a,c);
        updateAnsForCurrentComb(b,c,a);
        updateAnsForCurrentComb(c,a,b);
        updateAnsForCurrentComb(c,b,a);
        return ans;
    }
}