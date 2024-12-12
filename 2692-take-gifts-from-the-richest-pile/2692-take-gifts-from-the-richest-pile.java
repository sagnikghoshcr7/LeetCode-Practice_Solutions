class Solution {
    public long pickGifts(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));    // MAX-HEAP
        
        for(int i = 0; i<n; i++){
            pq.add(nums[i]);
        }
        
        long sum = 0;
        while(k-->0){
            pq.add((int)Math.sqrt(pq.remove()));
        }
        
        while(pq.size()>0){
            sum+=pq.remove();
        }

        return sum;
    }
}