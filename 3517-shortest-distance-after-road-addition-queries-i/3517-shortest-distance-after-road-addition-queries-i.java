class Solution {
    private void updateDistances(List<List<Integer>> graph, int current, int[] distances) {
        int newDist = distances[current] + 1;
        
        for (int neighbor : graph.get(current)) {
            if (distances[neighbor] <= newDist) continue;
            
            distances[neighbor] = newDist;
            updateDistances(graph, neighbor, distances);
        }
    }
    
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] distances = new int[n];
        for (int i = 0; i < n; ++i) {
            distances[i] = n - 1 - i;
        }
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i + 1 < n; ++i) {
            graph.get(i + 1).add(i);
        }
        
        int[] answer = new int[queries.length];
        int queryIdx = 0;
        
        for (int[] query : queries) {
            int source = query[0];
            int target = query[1];
            
            graph.get(target).add(source);
            distances[source] = Math.min(distances[source], distances[target] + 1);
            updateDistances(graph, source, distances);
            
            answer[queryIdx++] = distances[0];
        }
        
        return answer;
    }
}