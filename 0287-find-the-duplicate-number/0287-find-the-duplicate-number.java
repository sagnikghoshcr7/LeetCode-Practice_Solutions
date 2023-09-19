class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

// class Solution {
//     public static int findDuplicate_mark(int[] nums) {
//         int len = nums.length;
//         for (int num : nums) {
//             int idx = Math.abs(num);
//             if (nums[idx] < 0) {
//                 return idx;
//             }
//             nums[idx] = -nums[idx];
//         }

//         return len;
//     }
// }