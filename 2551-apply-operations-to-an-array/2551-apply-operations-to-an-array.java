class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i+1 < nums.length; ++i){
            if(nums[i] == nums[i+1]){          //update values of ith and (i+1)th value
                nums[i] = 2*nums[i]; 
                nums[i+1] = 0;
            }
        }
        int i = 0;
        for(int n: nums){                     // collect all noon zero values at front
            if(n != 0) nums[i++] = n;
        }
        while(i < nums.length) nums[i++] = 0;  //set values to zero for remainintg ith element
        return nums;
    }
}