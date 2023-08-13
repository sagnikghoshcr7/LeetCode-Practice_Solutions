class Solution {
    public int maxSum(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(maxDig(nums[i]) == maxDig(nums[j]))  max = Math.max(max, nums[i]+nums[j]);
            }
        }
        return max != 0 ? max : -1;
    }
    
    int maxDig(int num){
        int mdig = 0;
        while(num > 0){
            mdig = Math.max(mdig, num%10);
            num /= 10;
        }
        return mdig;
    }
}