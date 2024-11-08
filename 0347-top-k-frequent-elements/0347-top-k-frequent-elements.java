class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) map.put(i, map.getOrDefault(i, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            minHeap.offer(e);
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] ans = new int[k];
        for (int i=0; i<k; i++) {
            ans[i] = minHeap.poll().getKey();
        }

        return ans;
    }
}