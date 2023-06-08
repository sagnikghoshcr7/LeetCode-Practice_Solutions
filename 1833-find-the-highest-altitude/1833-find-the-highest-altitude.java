class Solution {
    public int largestAltitude(int[] gain) {
        int max  = 0;
        int alt = 0;
        for (int i = 0; i < gain.length; i++) {
            alt += gain[i];
            max = Math.max(alt, max);
        }
        return max;
    }
}