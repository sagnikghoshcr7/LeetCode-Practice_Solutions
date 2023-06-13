class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)));
            }
            result = Math.max(result, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        return result;
    }
}