class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]>avail=new PriorityQueue<>((a,b)->b[0]-a[0]);//sorting on the basis of descending order of profit
         PriorityQueue<int[]>rem=new PriorityQueue<>((a,b)->a[1]-b[1]);
         //sorting on the basins of ascending order of capital

        for(int i=0;i<profits.length;i++){
            rem.add(new int[]{profits[i],capital[i]});
        }
       
        long l=w;
        for(int i=0;i<k;i++){
           
            while(rem.size()>0 && rem.peek()[1]<=l){
                avail.add(rem.poll());//this queue stores on the basis of highest profit
            }
            if(avail.size()==0)break;
            int cur[]=avail.poll();
            l+=cur[0];
          
        }
        return (int)(l);
    }
}