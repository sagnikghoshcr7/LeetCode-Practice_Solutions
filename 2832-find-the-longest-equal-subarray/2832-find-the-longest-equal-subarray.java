class Solution {
    public int longestEqualSubarray(List<Integer> A, int k) {
        int maxfreq = 0;
        int left = 0;
        int n = A.size();

        Map<Integer, Integer> map = new HashMap<>();
        for (int right=0; right<n; right++) {
            // add the right element
            map.put(A.get(right), map.getOrDefault(A.get(right), 0) + 1);
            // keep track of max freq of an element
            maxfreq = Math.max(maxfreq, map.get(A.get(right)));

            // if we have too many elements to delete, delete from left
            if (right-left+1 - maxfreq > k) {
                map.put(A.get(left), map.get(A.get(left)) - 1);
                left++;
            }
        }
        return maxfreq;
    }
}