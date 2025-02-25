class Solution {
    public int numOfSubarrays(int[] arr) {
        int sum = 0, odd = 0;
        for (int i = 0; i < arr.length; ++i) {
            odd = arr[i] % 2 == 1 ? i - odd + 1 : odd;
            sum = (sum + odd)  % 1000000007;
        }
        return sum;
    }
}