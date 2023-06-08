class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int minInd = 0, maxInd = nums.length-1, n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] == 1) minInd = i;
            if (nums[i] == n) maxInd = i;
        }
        
        if (minInd < maxInd) return (minInd - 1 + n - maxInd);
        return (minInd - 1 + n - maxInd) -1;
    }
}