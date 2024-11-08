class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        LinkedList<Integer> temp = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, temp, target, 0, res);
        return res;
    }

    public void helper(int[] candidates, LinkedList<Integer> temp, Integer rest, Integer curr, List<List<Integer>> res) {
        if (rest == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i=curr; i<candidates.length; i++) {
            if (i>curr && candidates[i] == candidates[i-1]) continue;
            Integer next = candidates[i];
            if (rest - next < 0) break;

            temp.addLast(next);
            helper(candidates, temp, rest-next, i+1, res);
            temp.removeLast();
        }
    }
}