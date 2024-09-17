import java.util.*; 

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        if (A.isEmpty()) {
            return B.split(" ");
        } else if (B.isEmpty()) {
            return A.split(" ");
        } else if (A.equals(B)) {
            return new String[0];
        }
        
        Set<String> result = new HashSet<>();
        Set<String> words = new HashSet<>();
        
        
        for (String word : A.split(" ")) {
            if (words.contains(word)) {
                result.remove(word);
                continue; 
            }
            words.add(word);
            result.add(word);
        }
        
        for (String word : B.split(" ")) {
            if (words.contains(word)) {
                result.remove(word);
                continue; 
            }
            words.add(word);
            result.add(word);
        }
        
        int n = result.size(); 
        String arr[] = new String[n]; 
  
        // Copying contents of s to arr[] 
        System.arraycopy(result.toArray(), 0, arr, 0, n); 
        
        return arr;
    }
}