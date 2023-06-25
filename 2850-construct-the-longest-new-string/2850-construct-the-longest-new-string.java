class Solution {
    public int longestString(int x, int y, int z) {
        if (x>y) return 2*(2*y+1+z);
        else if (x<y) return 2*(2*x+1+z);
        else return 2*(2*x+z);
    }
}