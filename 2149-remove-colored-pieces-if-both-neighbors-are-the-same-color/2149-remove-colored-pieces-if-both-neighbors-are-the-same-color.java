class Solution {
    public boolean winnerOfGame(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap();
        map.put('A', 0); map.put('B', 0);

        for (int i=0; i<n; i++) {
            char ch = s.charAt(i);
            int count = 0;

            while (i<n && s.charAt(i) == ch) {
                i++;
                count++;
            }

            map.put(ch, map.get(ch) + Math.max(count-2, 0));
            i--;
        }

        return map.get('A') > map.get('B');
    }
}