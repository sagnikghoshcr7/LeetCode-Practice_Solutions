class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        return recurse(nums, 0, n-1, target);
    }
    
    boolean recurse(int[] nums, int low, int high, int target) {
        if(low > high)
            return false;
        int mid = (low + high)/2;
        if(target==nums[mid])
            return true;
        if(nums[mid] < nums[high])
           if(target >= nums[mid] && target <= nums[high])
               return recurse(nums, mid+1, high, target);
           else
               return recurse(nums, low, mid-1, target);
        else if(nums[mid] > nums[high])
           if(target >= nums[low] && target <= nums[mid])
               return recurse(nums, low, mid-1, target);
           else
               return recurse(nums, mid+1, high, target);
        else if(nums[mid] == nums[high])
            return recurse(nums, low, high-1, target);
        return false;
    }
}