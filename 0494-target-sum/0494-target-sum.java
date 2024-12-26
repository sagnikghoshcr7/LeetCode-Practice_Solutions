class Solution {
    Map <Map.Entry<Integer, Integer>, Integer> map;

    public int findTargetSumWays(int[] nums, int s) {        
        map = new HashMap<>();
        return dp(nums,s,nums.length-1,0);        
    }
    
    private int dp(int[] nums, int target, int index, int curSum){        
        Map.Entry<Integer,Integer> entry = Map.entry(index,curSum);
        if(map.containsKey(entry)) return map.get(entry);
        
        if(index<0 && curSum==target) return 1;
        if(index<0) return 0;
        
        int pos = dp(nums,target,index-1,nums[index]+curSum);
        int neg = dp(nums,target,index-1,-nums[index]+curSum);
        
        entry = Map.entry(index,curSum);
        map.put(entry,pos+neg);
        
        return pos + neg;        
    }
}