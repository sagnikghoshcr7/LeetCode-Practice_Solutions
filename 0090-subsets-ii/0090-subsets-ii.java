class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(0, nums, new ArrayList<Integer>(), res);
        return res;
    }

    public void helper(int index, int[] nums, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList(temp));
        for (int i=index; i<nums.length; i++) {
            if (i>index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            helper(i+1, nums, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}