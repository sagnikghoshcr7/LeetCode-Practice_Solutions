class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> ans = new ArrayList<>();
        int prev = -1, max = 0;

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            max = Math.max(max, map.get(ch));
            if (max == i) {
                ans.add(max - prev);
                prev = max;
            }
        }
        return ans;
    }
}