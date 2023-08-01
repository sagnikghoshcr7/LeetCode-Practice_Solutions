class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        backTrack(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    public void backTrack(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0){
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            comb.add(i);
            backTrack(combs, comb, i + 1, n, k-1);
            comb.remove(comb.size() -1);
        }
    }
}