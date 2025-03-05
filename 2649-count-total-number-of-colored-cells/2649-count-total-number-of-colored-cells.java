class Solution {
    public long coloredCells(int n) {
        return 1 + 4L * n * (n - 1) / 2;
    }
}