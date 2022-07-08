class Solution:
    def minCost(self, houses: List[int], cost: List[List[int]], m: int, n: int, target: int) -> int:
#         if 0 not in houses: #이미 다 채워져있는 경우
#             count = 1
#             Pcost = cost[0][houses[0]-1]
#             last = houses[0]
#             for i in range(1, len(houses)):
#                 Pcost += cost[i][houses[i]-1]
#                 if houses[i] != last:
#                     count += 1
#                     last = houses[i]
            
#             if count != target:
#                 return -1
#             else:
#                 return Pcost
        dp = [cost[0][::] if not houses[0] else [(0,float('inf'))[i != houses[0] - 1] for i in range(n)]]
        dp += [[float('inf')] * n for i in range(target)]
        
        for h,c in list(zip(houses,cost))[1:]:
            for i in range(target - 1, -1, -1):
                for j in range(n):
                    mini = min([dp[i][j]] + (dp[i-1][:j] + dp[i-1][j+1:]))
                    dp[i][j] = mini + c[j] if not h else mini if j == h-1 else float('inf')
        
        ans = min(dp[-2])
        return ans if ans != float('inf') else -1