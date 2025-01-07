class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(isSubstring(words[i], words, i)) {
                answer.add(words[i]);
            }
        }
        return answer;
    }
    
    private boolean isSubstring(String w, String[] words, int idx) {
        for(int i = 0; i < words.length; i++) {
            if(idx != i && w.length() <= words[i].length()) {
                if(words[i].contains(w)) {
                    return true;
                }
            }
        }
        return false;
    }
}