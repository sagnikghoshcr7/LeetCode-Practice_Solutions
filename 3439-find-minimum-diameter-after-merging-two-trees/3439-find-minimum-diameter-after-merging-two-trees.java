class Solution {
    int dia; // Variable to keep track of the maximum diameter found

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n1 = edges1.length + 1; // Number of nodes in the first tree
        int n2 = edges2.length + 1; // Number of nodes in the second tree

        // Initialize adjacency lists for both trees
        ArrayList<Integer>[] graph1 = new ArrayList[n1];
        ArrayList<Integer>[] graph2 = new ArrayList[n2];

        for (int i = 0; i < n1; i++) graph1[i] = new ArrayList<>();
        for (int i = 0; i < n2; i++) graph2[i] = new ArrayList<>();

        // Fill adjacency list for the first tree
        for (int i = 0; i < edges1.length; i++) {
            int u = edges1[i][0];
            int v = edges1[i][1];
            graph1[u].add(v);
            graph1[v].add(u);
        }

        // Fill adjacency list for the second tree
        for (int i = 0; i < edges2.length; i++) {
            int u = edges2[i][0];
            int v = edges2[i][1];
            graph2[u].add(v);
            graph2[v].add(u);
        }

        // Calculate diameter of the first tree
        dia = -1;
        boolean[] visited1 = new boolean[n1]; // Visited array to prevent revisiting nodes
        getDia(0, graph1, visited1);
        int d1 = dia;

        // Calculate diameter of the second tree
        dia = -1;
        boolean[] visited2 = new boolean[n2]; // Visited array to prevent revisiting nodes
        getDia(0, graph2, visited2);
        int d2 = dia;

        // Calculate the potential new diameter if we connect the two trees
        int cand = (d1 + 1) / 2 + (d2 + 1) / 2 + 1;

        // The minimum diameter after merging is the maximum of the potential new diameter and the original diameters
        return Math.max(cand, Math.max(d1, d2));
    }

    private int getDia(int src, ArrayList<Integer>[] graph, boolean[] visited) {
        visited[src] = true; // Mark the current node as visited
        int dch = -1; // Deepest Child Height
        int sdch = -1; // Second Deepest Child Height

        // Explore all children of the current node
        for (int child : graph[src]) {
            if (!visited[child]) {
                int ch = getDia(child, graph, visited); // Calculate the height of the child's subtree
                // Update the deepest and second deepest child heights
                if (ch > dch) {
                    sdch = dch;
                    dch = ch;
                } else if (ch > sdch) {
                    sdch = ch;
                }
            }
        }

        // Update the maximum diameter if the current path through this node is longer
        if (dch + sdch + 2 > dia) dia = dch + sdch + 2;
        dch += 1; // Increment the deepest child height for the current node
        return dch;
    }
}