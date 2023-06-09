class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int flag = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[flag]) {
                flag++;
                nums[flag] = nums[i];
            }
        }
        return flag + 1;
    }
}