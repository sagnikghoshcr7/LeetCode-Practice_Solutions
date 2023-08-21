class Solution {
    public int minimumSum(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i=1; set.size()<n; i++) {
            if (!set.contains(k-i)) {
                set.add(i);
                ans += i;
            }
        }
        return ans;
    }
}