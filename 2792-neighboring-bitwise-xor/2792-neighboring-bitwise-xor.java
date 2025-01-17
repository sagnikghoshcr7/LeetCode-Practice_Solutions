class Solution {
    public boolean doesValidArrayExist(int[] A) {
        return Arrays.stream(A).sum() % 2 == 0;
    }
}