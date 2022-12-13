class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i = 0 ; i<n; i++){
            dp[0][i]= matrix[0][i];
        }
        
        
        for(int i =1; i< n ;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for(int j = 0; j<n;j++){
                for(int d = -1; d<=1; d++){
                    if(0<=(j + d )&& (j+d )< n) {
                        int temp = dp[i][j];
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j+d] + matrix[i][j]);
                    }
                }
                
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        int result = Integer.MAX_VALUE;
        for(int i = 0; i<n ;i++){
            result = Math.min(result, dp[n-1][i]);
        }
        return result;
    }
}