class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int prefix = 0;
            for (int j = i; j < n; j++) {
                prefix += nums[j];
                arr.add(prefix);
            }
        }
        Collections.sort(arr);
        int result = 0;
        int MOD = 1000000007;
        for (int i = left - 1; i < right; i++) {
            result = (result + arr.get(i)) % MOD;
        }
        return result;
    }
}