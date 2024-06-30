class Solution {
    int[] parentA , parentB;
    int parentACount=1, parentBCount=1;

    public int maxNumEdgesToRemove(int n, int[][] edges) {        
        parentA = new int[n+1];
        parentB = new int[n+1];
        
        for( int i = 0; i < n; i++ ){
            parentA[i] = i;
            parentB[i] = i;
        }
        
        Arrays.sort(edges, (a,b)->a[0]-b[0]);        
        int edgesUsed = 0;        
        for( int i = edges.length - 1; i >= 0; i-- ){            
            if( edges[i][0] == 3 ){                
                if( union(edges[i][1], edges[i][2], parentA) && union(edges[i][1], edges[i][2], parentB) ) {
                    parentACount++;
                    parentBCount++;
                    edgesUsed++;
                }                
            } else if ( edges[i][0] == 2){
                if(union(edges[i][1], edges[i][2], parentB)) {
                    parentBCount++;
                    edgesUsed++;
                }
            } else if( edges[i][0] == 1 ){
                if(union(edges[i][1], edges[i][2], parentA)) {
                    parentACount++;
                    edgesUsed++;
                }
            }
            
            if( parentACount == n && parentBCount == n ) {
                return edges.length - edgesUsed;
            }
        }
        
        return -1;
    }

    private boolean union( int x, int y, int[] parent ){        
        int parentX = find(x, parent);
        int parentY = find(y, parent);
        
        if( parentX == parentY ) return false;        
        parent[parentX] = parentY;        
        return true;
    }

    private int find( int x, int[] parent ){        
        if( parent[x] == x ) return x;        
        return parent[x] = find(parent[x], parent);
    }
}