class Solution {
    public int minOperations(int[] nums, int k) {
        int mini = Integer.MAX_VALUE;
        for (int i : nums) mini = Math.min(mini, i);
        if (mini < k) return -1;

        BitSet st = new BitSet(100001);
        for (int i : nums) if (i > k) st.set(i);

        return st.cardinality();
    }
}