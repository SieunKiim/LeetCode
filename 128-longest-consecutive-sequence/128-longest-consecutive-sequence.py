import heapq
class Solution:
    # def longestConsecutive(self, nums):
    #     nums = set(nums)
    #     best = 0
    #     for x in nums:
    #         if x - 1 not in nums:
    #             y = x + 1
    #             while y in nums:
    #                 y += 1
    #             best = max(best, y - x)
    #     return best
    def longestConsecutive(self, nums: List[int]) -> int:
        dic = dict()
        for n in nums:
            dic[n] = 1
        Max = 0
        for k in dic:
            temp = k - 1
            while dic.get(temp):
                dic[k] += dic[temp]
                dic[temp] = 0
                temp -= 1
            Max = max(Max, dic[k])
        return Max
        
#----------------------------------------------------------------------------
        # if len(nums) == 0:
        #     return 0
        # nums.sort()
        # Max = 0
        # count = 1
        # last = nums[0]
        # for i in range(1,len(nums)):
        #     if last +1 ==  nums[i]:
        #         count += 1
        #     elif last == nums[i]:
        #         continue
        #     else:
        #         Max = max(Max, count)
        #         count = 1
        #     last = nums[i]
        # Max = max(Max, count)
        # return Max
#-------------------------------------------------------------------------------
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
#        return Max