class Solution {
    public int[] findRedundantConnection(int[][] edges) {        
        int n = edges.length;
        
        DSU dsu = new DSU(n);
        
        for(int[] edge : edges){
            int nodeX = edge[0] - 1;
            int nodeY = edge[1] - 1;
            
            int parentX = dsu.find(nodeX);
            int parentY = dsu.find(nodeY);
            
            if(parentX == parentY) return edge;

            dsu.unionSet(nodeX, nodeY);
        }
        
        return new int[0];
    }
}

class DSU {
    int[] parent;
    
    public DSU(int size){
        parent = new int[size];

        for(int i = 0; i < size; i++){
            parent[i] = i;
        }
    }

    public int find(int x){
        if(x == parent[x]) return x;
        
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void unionSet(int x, int y){
        int parentX = find(x);
        int parentY = find(y);

        parent[parentX] = parentY;        
    }
}