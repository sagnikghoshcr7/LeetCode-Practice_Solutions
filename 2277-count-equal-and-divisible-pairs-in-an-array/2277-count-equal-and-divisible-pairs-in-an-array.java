class Solution {
    public int countPairs(int[] nums, int k) {
        int pairs = 0;
        Map<Integer, List<Integer>> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            mpp.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        
        List<Integer> divisors = new ArrayList<>();
        for (int d = 1; d * d <= k; d++) {
            if (k % d == 0) {
                divisors.add(d);
                if (d != k / d) divisors.add(k / d);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : mpp.entrySet()) {
            Map<Integer, Integer> mpp2 = new HashMap<>();
            List<Integer> vec = entry.getValue();
            for (int i : vec) {
                int gcdd = gcd(i, k);
                int need = k / gcdd;
                pairs += mpp2.getOrDefault(need, 0);
                for (int d : divisors)
                    if (i % d == 0) mpp2.put(d, mpp2.getOrDefault(d, 0) + 1);
            }
        }
        return pairs;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}