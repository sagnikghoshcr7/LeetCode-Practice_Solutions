class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long nums1Zeroes = 0, nums2Zeroes = 0,sum1 = 0, sum2 = 0;
        for(int i : nums1){
            if(i == 0) nums1Zeroes++;
            sum1 += i;
        }

        for(int i : nums2){
            if(i == 0) nums2Zeroes++;
            sum2 += i;
        }

        long min1 = sum1 + nums1Zeroes;
        long min2 = sum2 + nums2Zeroes;

        if(nums1Zeroes == 0 && nums2Zeroes == 0){
            return sum1 == sum2 ? sum1 : -1;
        }else if(nums1Zeroes == 0){
            return sum2 + nums2Zeroes <=sum1 ?sum1 : -1;
        }else if (nums2Zeroes == 0){
            return sum1 + nums1Zeroes <= sum2 ? sum2 : -1;
        }
        return Math.max(min1, min2);
    }
}