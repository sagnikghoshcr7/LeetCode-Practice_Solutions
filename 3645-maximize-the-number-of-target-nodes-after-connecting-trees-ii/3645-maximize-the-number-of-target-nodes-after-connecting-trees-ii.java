class Solution {
    int evenA, oddA, evenB, oddB;
    List<List<Integer>> buildList(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }
    void dfsColor(List<List<Integer>> adj, int u, int parent, int[] color, boolean isA) {
        if (color[u] == 0) {
            if (isA) evenA++;
            else evenB++;
        } else {
            if (isA) oddA++;
            else oddB++;
        }
        for (int v : adj.get(u)) if (v != parent) {
            color[v] = color[u] ^ 1;
            dfsColor(adj, v, u, color, isA);
        }
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        List<List<Integer>> adjA = buildList(edges1), adjB = buildList(edges2);
        int n = adjA.size(), m = adjB.size();
        int[] colorA = new int[n], colorB = new int[m];
        Arrays.fill(colorA, -1);
        Arrays.fill(colorB, -1);
        evenA = oddA = evenB = oddB = 0;
        colorA[0] = 0;
        dfsColor(adjA, 0, -1, colorA, true);
        colorB[0] = 0;
        dfsColor(adjB, 0, -1, colorB, false);
        int maxiB = Math.max(evenB, oddB);
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = (colorA[i] == 0 ? evenA : oddA) + maxiB;
        return res;
    }
}