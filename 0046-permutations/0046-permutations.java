class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        findAllPermutations(res, nums, new ArrayList<>(), vis);
        return res;
    }

    public void findAllPermutations(List<List<Integer>> res, int[] nums, List<Integer> curr, boolean[] vis) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList(curr));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (vis[i] == true) continue;
            curr.add(nums[i]);
            vis[i] = true;
            findAllPermutations(res, nums, curr, vis);
            curr.remove(curr.size() - 1);
            vis[i] = false;
        }
    }
}