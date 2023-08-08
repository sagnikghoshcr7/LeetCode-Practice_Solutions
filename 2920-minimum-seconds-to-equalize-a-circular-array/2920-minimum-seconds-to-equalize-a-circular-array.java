class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums.get(i))){
                map.put(nums.get(i), new ArrayList<>());
            }
            map.get(nums.get(i)).add(i);
        }
        
        for(Integer val: map.keySet()){
            List<Integer> indices = map.get(val);
            int elementCt = indices.size();
            int startElements = indices.get(0);
            int endElements = n-1 - indices.get(elementCt-1);
            int currMax = (startElements + endElements+1)/2;
            for(int i=1;i<elementCt;i++){
                currMax = Math.max(currMax, (indices.get(i)-indices.get(i-1))/2);
            }
            ans = Math.min(ans, currMax);
        }
        return ans;
    }
}