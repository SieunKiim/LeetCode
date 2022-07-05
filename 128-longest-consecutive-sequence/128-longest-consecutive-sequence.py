import heapq
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        nums.sort()
        Max = 0
        count = 1
        last = nums[0]
        for i in range(1,len(nums)):
            if last +1 ==  nums[i]:
                count += 1
            elif last == nums[i]:
                continue
            else:
                Max = max(Max, count)
                count = 1
            last = nums[i]
        Max = max(Max, count)
        return Max
            
#         heapq.heapify(nums)
        
#         last = heapq.heappop(nums)
#         Max = 0
#         count = 1
#         while nums:
#             temp = heapq.heappop(nums)
#             if last+1 == temp:
#                 count += 1
#             elif last == temp:
#                 continue
#             else:
#                 Max = max(Max, count)
#                 count = 1
#             last = temp
#         Max = max(Max, count)
        return Max