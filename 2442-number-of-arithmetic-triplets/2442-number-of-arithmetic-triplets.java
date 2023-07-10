class Solution {
        public int arithmeticTriplets(int[] nums, int diff) {
        int cnt = 0;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num - diff) && seen.contains(num - diff * 2)) {
                ++cnt;
            }
            seen.add(num);
        }
        return cnt;
    }
}