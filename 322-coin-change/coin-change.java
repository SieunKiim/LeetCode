class Solution {
    public int coinChange(int[] coins, int amount) {
        int coinSize = coins.length;
        int[][] dp = new int[coinSize+1][amount+1];
        for(int i = 0;i<coinSize + 1;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            // int count = 0;
            // for(int j = 0; j<= amount; j = j+coins[i-1]){
            //     dp[i][j] = count++;
            // }
            dp[i][0] = 0;
            // System.out.println(Arrays.toString(dp[i]));
        }
        // dp[0][0] = 0;

        for(int i =1;i<coinSize+1;i++){
            int coin = coins[i-1];
            // System.out.println("coin : " + coin);
            for(int j = 1;j<= amount;j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j]);
                if(j>= coin && dp[i][j-coin] != Integer.MAX_VALUE){
                    // System.out.println("j -> " + dp[i][j] + " , " + (dp[i][j-coin]+1));
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-coin]+1);
                }
            }
            // System.out.println(Arrays.toString(dp[i]));
        }
        return dp[coinSize][amount] == Integer.MAX_VALUE? -1 : dp[coinSize][amount];
    }
}