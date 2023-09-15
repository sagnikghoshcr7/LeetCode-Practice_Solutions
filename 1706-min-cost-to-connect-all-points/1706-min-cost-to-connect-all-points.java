public class Solution {
    public static int manhattan_distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        HashMap<Integer, Integer> heap_dict = new HashMap<>();
        heap_dict.put(0, 0);
        
        PriorityQueue<int[]> min_heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        min_heap.add(new int[]{0, 0});
        
        int mst_weight = 0;
        
        while (!min_heap.isEmpty()) {
            int[] top = min_heap.poll();
            int w = top[0], u = top[1];
            
            if (visited[u] || heap_dict.getOrDefault(u, Integer.MAX_VALUE) < w) continue;
            
            visited[u] = true;
            mst_weight += w;
            
            for (int v = 0; v < n; ++v) {
                if (!visited[v]) {
                    int new_distance = manhattan_distance(points[u], points[v]);
                    if (new_distance < heap_dict.getOrDefault(v, Integer.MAX_VALUE)) {
                        heap_dict.put(v, new_distance);
                        min_heap.add(new int[]{new_distance, v});
                    }
                }
            }
        }
        
        return mst_weight;
    }
}