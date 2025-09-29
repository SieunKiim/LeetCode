class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = i + 1; k < j; k++) {
                    int score = values[i] * values[k] * values[j]  // 현재 삼각형
                              + dp[i][k]                             // 왼쪽 부분
                              + dp[k][j];                            // 오른쪽 부분
                    dp[i][j] = Math.min(dp[i][j], score);
                }
            }
        }
        
        return dp[0][n - 1];
    }
}