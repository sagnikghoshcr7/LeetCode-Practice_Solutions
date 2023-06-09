class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i : prices) {
            if (i < minPrice) minPrice = i;
            if (i - minPrice > maxProfit) maxProfit = i - minPrice;
        }

        return maxProfit;
    }
}