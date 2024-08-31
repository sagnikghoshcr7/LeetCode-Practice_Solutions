class Solution {
    class Info{
        int node;
        double prob;

        Info(int node, double prob){
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Info>> edgeList = new ArrayList<>();

        for(int i = 0 ; i < n; i++){
            edgeList.add(new ArrayList<>());
        }

        for(int i = 0 ; i< edges.length; i++){
           edgeList.get(edges[i][0]).add(new Info(edges[i][1], succProb[i]));
           edgeList.get(edges[i][1]).add(new Info(edges[i][0], succProb[i]));
        }

        HashSet<Integer> visited = new HashSet<>();

        PriorityQueue<Info> pq = new PriorityQueue<>((p1, p2)->{
            if(p1.prob > p2.prob) return -1;
            return 1;
        });

        pq.add(new Info(start, 1.0));
        
        while(!pq.isEmpty()){
            Info info = pq.remove();            
            if(info.node == end) return info.prob;

            if(!visited.contains(info.node)){
                visited.add(info.node);
                double prob = info.prob;

                for(Info i: edgeList.get(info.node)){
                    if(!visited.contains(i.node)){
                        pq.add(new Info(i.node, prob * i.prob));
                    }
                }
            }
        }

        return 0.0;        
    }
}