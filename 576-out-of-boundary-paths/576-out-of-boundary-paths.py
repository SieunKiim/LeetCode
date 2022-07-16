from collections import deque
class Solution:
    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        if maxMove == 0:
            return 0
        di = [-1, 0, 1, 0]
        dj = [0, -1, 0, 1]
        dp = [[[-1]*(maxMove+1) for _ in range(n+1)] for _ in range(m+1)]
        
        # 가로 n
        # 세로 m
        def recursion(i,j,move):
            if move < 0 :
                return 0
            if i < 0 or i >= m or j < 0 or j >= n:
                return 1
            if dp[i][j][move] != -1:
                return dp[i][j][move]
            temp = 0
            for d in range(4):
                temp += recursion(i+di[d], j+dj[d], move-1)
            dp[i][j][move] = temp
            return dp[i][j][move]
        want = recursion(startRow, startColumn, maxMove)% (10 ** 9 + 7)
        return want 