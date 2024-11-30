class Solution {
    public void dfs(List<Integer> pa, Map<Integer, Stack<Integer>> gr, int st){
        Stack<Integer> nei= gr.getOrDefault(st, new Stack<>());
        while(!nei.isEmpty()){
            int ne= nei.pop();
            dfs(pa, gr, ne);
        }
        pa.add(st);
    }
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Stack<Integer>> gr= new HashMap<>();
        Map<Integer, Integer> in= new HashMap<>();
        Map<Integer, Integer> out= new HashMap<>();
        for(int[] a: pairs){
            int u= a[0], v= a[1];
            gr.computeIfAbsent(u, k-> new Stack<>()).push(v);
            out.put(u, out.getOrDefault(u, 0)+1);
            in.put(v, in.getOrDefault(v, 0)+1);
        }
        int st= pairs[0][0];
        for(int k: gr.keySet()){
            if(out.getOrDefault(k, 0)> in.getOrDefault(k, 0)){
                st= k;
                break;
            }
        }
        List<Integer> path= new ArrayList<>();
        dfs(path, gr, st);
        Collections.reverse(path);
        int[][] res= new int[pairs.length][2];
        for(int i=0; i<path.size()-1; i++){
            res[i][0]= path.get(i);
            res[i][1]= path.get(i+1);
        }
        return res;
    }
}