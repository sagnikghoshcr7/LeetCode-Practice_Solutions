class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int ans=Integer.MAX_VALUE;
        TreeSet<Integer> nm=new TreeSet<>();
        int size=nums.size();
        for(int i=x;i<size;i++)
        {
            nm.add(nums.get(i-x));
            Integer val=nm.ceiling(nums.get(i));
            if(val!=null)
            {
                ans=Math.min(ans,Math.abs(nums.get(i)-val));
            }
            Integer val1=nm.floor(nums.get(i));
            if(val1!=null)
            {
                ans=Math.min(ans,Math.abs(nums.get(i)-val1));
            }
        }
        return ans;
    }
}