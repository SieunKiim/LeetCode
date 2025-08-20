class Solution {
    public int countSquares(int[][] matrix) {
        int res = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n+1][m+1];
        for(int i =1;i<=n; i++){
            for(int j =1;j<=m;j++){
                if(matrix[i-1][j-1] == 0)continue;
                dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                res+= dp[i][j];
            }
        }
        return res;
    }
}