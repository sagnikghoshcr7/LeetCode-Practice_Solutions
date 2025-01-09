class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = -1, hi = nums.length;
        while (hi-lo>1) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid]>=target) hi = mid;
            else lo = mid;
        }

        return hi;
    }
}