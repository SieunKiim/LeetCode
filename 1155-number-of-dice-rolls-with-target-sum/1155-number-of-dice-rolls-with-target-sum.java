class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = 1000000007;
        int[][] dp = new int[n+1][target+1];
        for(int i = 1; i <=k; i++){
            if(i > target) break;
            dp[1][i] = 1;
        }
        for(int i = 2; i <=n; i++){
            for(int j = 1; j<=target; j++){
                if(dp[i-1][j] != 0){
                    for(int p = 1; p <= k; p++){
                        if(j+p > target) break;
                        dp[i][j+p] = (dp[i][j+p]+dp[i-1][j])%mod;
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        // System.out.println("");

        return dp[n][target]%mod;
    }
}