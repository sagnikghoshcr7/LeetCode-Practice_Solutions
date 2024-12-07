class Solution {
    private boolean canDivide(int[] nums, int maxBalls, int maxOperations) {
        int ops = 0;
        for (int n : nums) {
            ops += (n + maxBalls - 1) / maxBalls - 1;
            if (ops > maxOperations) return false;
        }
        return true;
    }
    
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int res = right;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, mid, maxOperations)) {
                right = mid;
                res = right;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}