class Solution {
    public int maxProfit(int[] prices) {
        int preMin = prices[0];

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - preMin);
            preMin = Math.min(preMin, prices[i]);
        }
        return max;
    }
}
