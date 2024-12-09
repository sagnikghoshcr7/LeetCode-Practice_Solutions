class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n]; // Prefix array to count special pairs
        boolean[] result = new boolean[queries.length]; // Result array
        
        // Step 1: Build the prefix array
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            if ((nums[i - 1] % 2 == 0 && nums[i] % 2 == 0) || 
                (nums[i - 1] % 2 != 0 && nums[i] % 2 != 0)) {
                prefix[i]++;
            }
        }

        // Step 2: Process each query
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            // Calculate the number of special pairs in the range
            int specialCount = prefix[right] - (left > 0 ? prefix[left] : 0);
            
            // If no special pairs, the result is true; otherwise, false
            result[i] = (specialCount == 0);
        }

        return result;
    }
}