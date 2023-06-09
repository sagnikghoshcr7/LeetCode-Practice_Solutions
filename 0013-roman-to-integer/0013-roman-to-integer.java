class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for (int i=0; i<s.length()-1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        res += map.get(s.charAt(s.length() - 1));
        return res;
    }
}

// First we use a hashmap to map the conversions of roman digits to integer.
// Now, if a numeral with smaller value precedes one with a larger value, we subtract the value from the total, otherwise we add the value to the total.
// At the end, we still have to add the last character value.