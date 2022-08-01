class Solution:
    def uniquePaths(self, M: int, N: int) -> int:
        # m : 세로, n : 가로
        m = M-1
        n = N-1
        
        temp = 1
        
        for i in range(m+n, max(n,m), -1):
            temp *= i
        print(temp)
        for j in  range(min(n,m), 0, -1):
            temp /= j
        print(temp)
        print(int(temp))
        return(int(temp))