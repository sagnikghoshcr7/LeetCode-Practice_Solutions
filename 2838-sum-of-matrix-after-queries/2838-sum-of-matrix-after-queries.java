class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        long ans = 0;
        int m = queries.length;
        int rowCt = n;
        int colCt = n;
        Set<Integer> visitedCols = new HashSet<>();
        Set<Integer> visitedRows = new HashSet<>();
        
        for(int i=m-1;i>=0;i--){
            int type = queries[i][0];
            int index = queries[i][1];
            long val = (long)queries[i][2];
            
            if(type==0 && !visitedRows.contains(index)){
                ans = ans + ((long)val *(long)colCt);
                rowCt--;
                visitedRows.add(index);
            }else if(type == 1 && !visitedCols.contains(index)){
                ans = ans + ((long)val *(long)rowCt);
                colCt--;    
                visitedCols.add(index);
            }
            
        }
        return ans;
    }
}