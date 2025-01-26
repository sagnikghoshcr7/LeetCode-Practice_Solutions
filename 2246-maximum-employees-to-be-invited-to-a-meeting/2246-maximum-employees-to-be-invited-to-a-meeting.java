class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        boolean[] visited = new boolean[n];
        // topological sort which picks out acyclic part.
        int[] indegrees = new int[n];
        for(int i = 0; i < n; ++i) {
            int j = favorite[i]; // i -> favorite[i].
            ++indegrees[j];
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; ++i) {
            if (indegrees[i] == 0) {
                visited[i] = true;
                q.offer(i);
            }
        }
        int[] dp = new int[n]; // dp[i] is the longest path leading to i exclusively.
        while(!q.isEmpty()) {
            int i = q.poll();
            int j = favorite[i];
            dp[j] = Math.max(dp[j], dp[i] + 1);
            if (--indegrees[j] == 0) {
                visited[j] = true;
                q.offer(j);
            }
        }
        // now not visited nodes are all loops. check each loop's length.
        int result = 0; // loops of length > 2.
        int result2 = 0; // loops of length 2 and paths leading to both nodes.
        for(int i = 0; i < n; ++i) {
            if (visited[i] == false) {
                int length = 0;
                for(int j = i; visited[j] == false; j = favorite[j]) {
                    visited[j] = true;
                    ++length;
                }
                if (length == 2) {
                    result2 += 2 + dp[i] + dp[favorite[i]];
                } else {
                    result = Math.max(result, length);
                }
            }
        }
        return Math.max(result, result2);
    }
}