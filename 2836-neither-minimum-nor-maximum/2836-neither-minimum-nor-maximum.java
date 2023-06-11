class Solution {
    public int findNonMinOrMax(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) min = Math.min(min, num);
            if (num > max) max = Math.max(max, num);
        }

        for (int num : nums) {
            if (num != min && num != max) return num;
        }
        return -1;        
    }
}