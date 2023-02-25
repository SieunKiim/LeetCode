class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        
        int maxGap = 0;
        int small = prices[0];
        int big = prices[0];
        
        for(int i = 1 ; i< prices.length; i++){
            int now = prices[i];
            if(now < small){
                maxGap = Math.max(maxGap, big-small);
                small = now;
                big = now;
            } else {
                System.out.println(big+" "+now);
                big = Math.max(big, now);
            }
        }
        maxGap = Math.max(maxGap, big-small);
        return maxGap;
    }
}