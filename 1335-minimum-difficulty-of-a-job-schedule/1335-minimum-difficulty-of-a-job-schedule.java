class Solution {
    // copied discussion
    public int minDifficulty(int[] A, int D) {
        int n = A.length, maxd;
        if (n < D) return -1;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; --i)
            dp[i] = Math.max(dp[i + 1], A[i]);
        for (int d = 2; d <= D; ++d) {
            for (int i = 0; i <= n - d; ++i) {
                maxd = 0;
                dp[i] = Integer.MAX_VALUE;
                for (int j = i; j <= n - d; ++j) {
                    maxd = Math.max(maxd, A[j]);
                    dp[i] = Math.min(dp[i], maxd + dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}
