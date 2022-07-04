class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        result = [1] * n
        
        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                result[i] = result[i-1] + 1
        
        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i+1]:
                result[i] = max(result[i+1] + 1, result[i])

        return sum(result)
            
# 1   3   6   7   8   3   2   1   4   7   4   3   2   1

# 1   2   3   4   5   3   2   1   2   5   4   3   2   1