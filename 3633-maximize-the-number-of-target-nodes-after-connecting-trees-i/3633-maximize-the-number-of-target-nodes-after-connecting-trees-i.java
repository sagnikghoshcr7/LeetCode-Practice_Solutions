class Solution {
    private List<List<Integer>> buildList(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }

    private int dfs(List<List<Integer>> adj, int u, int p, int k) {
        if (k < 0) return 0;
        int cnt = 1;
        for (int v : adj.get(u)) {
            if (v != p) cnt += dfs(adj, v, u, k - 1);
        }
        return cnt;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> adj1 = buildList(edges1);
        List<List<Integer>> adj2 = buildList(edges2);
        int m = adj2.size(), maxiB = 0;
        for (int i = 0; i < m; i++) {
            maxiB = Math.max(maxiB, dfs(adj2, i, -1, k - 1));
        }
        int n = adj1.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(adj1, i, -1, k) + maxiB;
        }
        return res;
    }
}