class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.size();
        long ans = 0;
        map.put(0,1);
        int prefixRemainder = 0;
        for(int i=0;i<n;i++){
            prefixRemainder = (prefixRemainder +  ((nums.get(i)%m == k)?1:0))%m;
            int targetRem = (prefixRemainder-k+m)%m;
            ans += map.getOrDefault(targetRem,0);
            map.put(prefixRemainder, map.getOrDefault(prefixRemainder,0)+1);
        }
        return ans;
    }
}