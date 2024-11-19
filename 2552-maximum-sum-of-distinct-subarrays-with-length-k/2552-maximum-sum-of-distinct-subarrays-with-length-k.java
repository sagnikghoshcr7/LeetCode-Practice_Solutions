class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> elements = new HashSet<>();
        long currentSum = 0;
        long maxSum = 0;
        int begin = 0;
        
        for (int end = 0; end < n; end++) {
            if (!elements.contains(nums[end])) {
                currentSum += nums[end];
                elements.add(nums[end]);
                
                if (end - begin + 1 == k) {
                    maxSum = Math.max(maxSum, currentSum);
                    currentSum -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
            } else {
                while (nums[begin] != nums[end]) {
                    currentSum -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
                begin++;
            }
        }
        
        return maxSum;
    }
}