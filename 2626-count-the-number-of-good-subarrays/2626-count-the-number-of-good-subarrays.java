class Solution {
    public long countGood(int[] A, int k) {
        long res = 0L;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0, j = 0; j < A.length; ++j){
            k -= count.getOrDefault(A[j],0);
            count.put(A[j],count.getOrDefault(A[j],0)+1);
            // Or
            /*
            count.putIfAbsent(A[j],0);
            k -= count.get(A[j]);
            count.put(A[j],count.get(A[j])+1);
            */
            while(k <= 0){
                count.put(A[i],count.get(A[i])-1);
                k += count.get(A[i++]);
            }
            res += i;
        }
        return res;
    }
}