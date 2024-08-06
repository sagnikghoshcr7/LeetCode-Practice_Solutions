class Solution {
    public int minimumPushes(String word) {
        // Count the frequency of each letter
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Sort the frequencies in descending order
        Arrays.sort(freq);
        
        int totalPushes = 0;
        int multiplier = 1;
        
        // Assign letters to keys, starting from the most frequent
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;
            
            if ((25 - i) % 8 == 0 && i != 25) multiplier++;
            
            totalPushes += freq[i] * multiplier;
        }
        
        return totalPushes;
    }
}