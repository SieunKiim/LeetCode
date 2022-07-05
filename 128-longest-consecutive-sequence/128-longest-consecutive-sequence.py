import heapq
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) < 1:
            return 0
        heapq.heapify(nums)
        
        last = heapq.heappop(nums)
        Max = 0
        count = 1
        while nums:
            temp = heapq.heappop(nums)
            if last+1 == temp:
                count += 1
            elif last == temp:
                continue
            else:
                Max = max(Max, count)
                count = 1
            last = temp
        Max = max(Max, count)
        return Max