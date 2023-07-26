class Solution {
    public long maxArrayValue(int[] nums) {
        long sum = 0;
        for (int i=nums.length-1; i>=0; i--) {
            if (nums[i] <= sum) sum += nums[i];
            else sum = nums[i];
        }
        return sum;
    }
}