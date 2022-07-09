import sys
import heapq
class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        n = len(nums)
        heap_window_k = []
        dp = [0] * n
        
        for i in range(n):
            dp[i] = nums[i]
            if i == 0: 
                heapq.heappush(heap_window_k, (-nums[0], 0))
                continue
                
            while heap_window_k[0][1] < i-k:
                heapq.heappop(heap_window_k)
            
            dp[i] += (-heap_window_k[0][0])
            heapq.heappush(heap_window_k, (-dp[i], i))
        
        return dp[n-1]