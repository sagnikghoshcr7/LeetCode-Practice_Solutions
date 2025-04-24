class Solution {
    public int countDistinct(int[] a) {
        int count = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i: a) set.add(i);
        return set.size();
    }
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        int distinct = countDistinct(nums);
        for (int i=0; i<n; i++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int j=i; j<n; j++) {
                set.add(nums[j]);
                if (set.size() == distinct) {
                    count += n-j;
                    break;
                }
            }
        }
        return count;
    }
}