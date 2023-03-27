class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        
        for(int i =0 ;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i == 0 && j == 0){
                    dp[0][0] = grid[0][0];
                } else if(i == 0 && j != 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if(i != 0 && j == 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n-1][m-1];
    }
}