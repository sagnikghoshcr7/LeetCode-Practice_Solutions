class Solution {
    private static int gcd(int a, int b) {if (b == 0) return a; return gcd(b, a % b);}
    public int countBeautifulPairs(int[] nums) {
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(gcd(Integer.parseInt(String.valueOf(nums[i]).charAt(0)+""),nums[j]%10) == 1) cnt++;
            }
        }
        return cnt;
    }
}