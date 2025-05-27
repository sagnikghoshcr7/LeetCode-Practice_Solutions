class Solution {
    public int differenceOfSums(int n, int m) {
        int totalSum = n * (n + 1) / 2;
        int divisibleSum = m * (n / m) * (n / m + 1);
        return totalSum - divisibleSum;
    }
}