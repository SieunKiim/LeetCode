import sys
import heapq
class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        dp = [0] * len(nums)
        dp[0] = nums[0]
        heap = [(-nums[0],0)]

        for i in range(1, len(nums)):
            while heap:
                if i - heap[0][1] <= k:
                    break
                else:
                    heapq.heappop(heap)
            temp = heap[0]
            num = -temp[0] + nums[i]
            dp[i] = num
            heapq.heappush(heap, (-num, i))
                
        return(dp[-1])