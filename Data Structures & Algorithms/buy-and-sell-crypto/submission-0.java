class Solution {
    public int maxProfit(int[] prices) {
        int[] post = new int[prices.length];
        post[prices.length-1] = prices[prices.length-1];
        for (int i = prices.length-2; i >= 0; i--) {
            post[i] = Math.max(post[i+1], prices[i]);
        }

        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, post[i] - prices[i]);
        }
        return max;
    }
}
