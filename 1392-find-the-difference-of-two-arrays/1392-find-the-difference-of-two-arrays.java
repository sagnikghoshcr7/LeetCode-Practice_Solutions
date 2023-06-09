class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();

        for (int i : nums1) {set1.add(i);}
        for (int i : nums2) {set2.add(i);}

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        for (int i : set1) {
            if (!set2.contains(i)) {res.get(0).add(i);}
        }
        for (int i: set2) {
            if (!set1.contains(i)) {res.get(1).add(i);}
        }
        return res;
    }
}