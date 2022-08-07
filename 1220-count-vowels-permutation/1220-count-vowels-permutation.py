class Solution:
    def countVowelPermutation(self, n: int) -> int:
        mod = 10**9 + 7
        dp = [[0 for _ in range(5)] for _ in range(n+1)]
        for i in range(5):
            dp[1][i] = 1
        
        if n <= 1:
            return sum(dp[n])
        
        for i in range(2, n+1):
            for j in range(5):
                if j == 0:
                    dp[i][j] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4])%mod
                elif j == 1:
                    dp[i][j] = (dp[i-1][0] + dp[i-1][2])%mod
                elif j == 2:
                    dp[i][j] = (dp[i-1][1] + dp[i-1][3])%mod
                elif j == 3:
                    dp[i][j] = (dp[i-1][2])%mod
                else:
                    dp[i][j] = (dp[i-1][3] + dp[i-1][2])%mod
        
        # for i in range(n+1):
        #     print(dp[i])
        return (sum(dp[i]) % (mod))