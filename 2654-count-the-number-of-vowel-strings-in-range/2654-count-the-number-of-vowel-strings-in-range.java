class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int count=0;
        while(left<=right)
        {
            if(vowel(words[left].charAt(0))&&vowel(words[left].charAt(words[left].length()-1)))
            count++;
            left++;
        }
        return count;
    }
    boolean vowel(char ch)
    {
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
        return true;
        else return false;
    }
}