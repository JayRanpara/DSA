class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = Integer.MIN_VALUE;
        int buy = prices[0];
        for(int i=1; i<n; i++) {
            if(buy<=prices[i]) {
                maxProfit  = Math.max(prices[i]-buy,maxProfit);
            }
            else{
                buy = prices[i];
            }
        }
        return maxProfit==Integer.MIN_VALUE?0:maxProfit;
    }
}
