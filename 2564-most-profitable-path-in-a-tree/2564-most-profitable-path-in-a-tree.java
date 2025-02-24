class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        ArrayList<Integer>[] graph = new ArrayList[amount.length];
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] bobPath = new int[amount.length];
        Arrays.fill(bobPath, -1);
        ArrayList<Integer> path = new ArrayList<>();
        fillBobPath(bob, -1, path, graph);
        
        for (int i = 0; i < path.size(); i++) {
            bobPath[path.get(i)] = i;
        }

        return getAliceMaxScore(0, -1, 0, bobPath, graph, 0, amount);
    }

    private boolean fillBobPath(int node, int parentNode, ArrayList<Integer> path, ArrayList<Integer>[] graph) {
        if (node == 0) return true;
        for (int neighborNode : graph[node]) {
            if (neighborNode != parentNode) {
                path.add(node);
                if (fillBobPath(neighborNode, node, path, graph)) return true;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    private int getAliceMaxScore(int node, int parentNode, int currScore, int[] bobPath, ArrayList<Integer>[] graph, int timestamp, int[] amount) {
        if (bobPath[node] == -1 || bobPath[node] > timestamp) {
            currScore += amount[node];
        } else if (bobPath[node] == timestamp) {
            currScore += amount[node] / 2;
        }
        if (graph[node].size() == 1 && node != 0) return currScore;
        int maxScore = Integer.MIN_VALUE;
        for (int neighborNode : graph[node]) {
            if (neighborNode != parentNode) {
                maxScore = Math.max(maxScore, getAliceMaxScore(neighborNode, node, currScore, bobPath, graph, timestamp + 1, amount));
            }
        }
        return maxScore;
    }
}