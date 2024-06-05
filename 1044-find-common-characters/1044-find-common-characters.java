class Solution {
    public List<String> commonChars(String[] A) {
        if(A == null || A.length == 0) return new ArrayList<String>();

        List<String> result = new ArrayList<>();
        int [] map = new int[26];
        fillMap(map, A[0]);
        
        for(String word: A) {
            int [] temp = new int[26];
            fillMap(temp, word);
            trimMap(map, temp);            
        }
        result = getResult(map);
        return result;
    }
    
    public void fillMap(int [] map, String word) {
        for(char c: word.toCharArray()) {
            map[c - 'a']++;
        }
    }
    
    public void trimMap(int [] map, int [] curr) {
        for(int i = 0; i < 26; i++) {
            if(map[i] != curr[i]) {
                map[i] = Math.min(map[i], curr[i]);
            }
        }
    }
    
    public List<String> getResult(int [] map) {
        List<String> result = new ArrayList<>();
        for(char j = 'a'; j <= 'z'; j++) {
            if(map[j - 'a'] > 0) {
                for(int k = 0; k < map[j - 'a']; k++) {
                    result.add(String.valueOf(j));
                }
            }
        }
        
        return result;
    }
}