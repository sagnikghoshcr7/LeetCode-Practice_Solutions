class KthLargest {
    final PriorityQueue<Integer> pq;
    final int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int n : a) add(n);
    }

    public int add(int n) {
        if (pq.size() < k) pq.offer(n);
        else if (pq.peek() < n) {
            pq.poll();
            pq.offer(n);
        }
        return pq.peek();
    }
}