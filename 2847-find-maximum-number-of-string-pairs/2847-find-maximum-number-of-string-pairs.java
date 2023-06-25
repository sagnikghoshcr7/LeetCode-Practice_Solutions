class Solution {    
    private static final StringBuilder sb = new StringBuilder();

    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        Set<String> set = new HashSet<String>(words.length);

        for (String word : words) {
            String reversedWord = sb.append(word).reverse().toString();
            if (set.contains(reversedWord)) count++;

            set.add(word);
            sb.setLength(0);
        }

        return count;
    }
}