class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> revEdgeList = new ArrayList<>();

        int n = graph.length;

        for(int i = 0; i < n; i++){
           revEdgeList.add(new ArrayList<>()); 
        }

        int[] outorder = new int[n];

        for(int i = 0; i < n; i++){
            outorder[i] = graph[i].length;
            for(int node: graph[i]){
                revEdgeList.get(node).add(i);
            }
        }

        Queue<Integer> qu = new ArrayDeque<>();


        for(int i = 0; i < n; i++){
            if(outorder[i] == 0){
                qu.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!qu.isEmpty()){
            int node = qu.remove();
          
            ans.add(node);
         
            for(int neigh: revEdgeList.get(node)){
                outorder[neigh]--;
 
                if(outorder[neigh] == 0) qu.add(neigh);
            }
        }

        Collections.sort(ans);
     
        return ans;
    }
}