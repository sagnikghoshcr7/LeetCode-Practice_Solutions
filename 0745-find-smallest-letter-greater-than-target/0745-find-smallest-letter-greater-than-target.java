class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (letters[mid] <= target) l = mid + 1;
            else h = mid;
        }
        return letters[l % letters.length];
    }
}