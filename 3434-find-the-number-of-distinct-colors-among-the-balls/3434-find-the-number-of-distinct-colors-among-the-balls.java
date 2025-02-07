class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> ball = new HashMap<>(), color = new HashMap<>();
        int n = queries.length, distinct = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            int pos = queries[i][0], c = queries[i][1];
            if(ball.containsKey(pos)){
                int cnt = color.get(ball.get(pos)) - 1;
                if(cnt == 0){ color.remove(ball.get(pos)); distinct--; }
                else color.put(ball.get(pos), cnt);
            }
            ball.put(pos, c);
            int cnt = color.getOrDefault(c, 0) + 1;
            color.put(c, cnt);
            if(cnt == 1) distinct++;
            ans[i] = distinct;
        }
        return ans;
    }
}