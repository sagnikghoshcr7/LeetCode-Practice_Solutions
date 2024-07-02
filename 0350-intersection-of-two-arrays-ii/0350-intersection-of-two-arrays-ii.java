class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map <Integer, Integer> map = new HashMap<>();
        ArrayList <Integer> res = new ArrayList<>();
        for (int i=0; i<nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }
        for (int i=0; i<nums2.length; i++) {
            if (map.containsKey(nums2[i])&&map.get(nums2[i])>0) {
                map.put(nums2[i], map.get(nums2[i]) - 1);
                res.add(nums2[i]);
            }
        }
        int[] a = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            a[i] = res.get(i);
        }
        return a;
    }
}