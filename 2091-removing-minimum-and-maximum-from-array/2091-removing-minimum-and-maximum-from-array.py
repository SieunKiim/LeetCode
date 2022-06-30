from collections import deque
class Solution(object):
    def minimumDeletions(self, nums):
        big = -999999
        bigIndex = 0
        small = 999999
        smallIndex = len(nums)+1
        for n in range(len(nums)):
            if nums[n] > big:
                big = nums[n]
                bigIndex = n
            if nums[n] < small:
                small = nums[n]
                smallIndex = n
        
        
        b = max(bigIndex, smallIndex)
        s = min(bigIndex, smallIndex)
        print(s, b)
        print(len(nums))
#         if b <= len(nums)//2:
#             return b + 1
        
#         elif len(nums)//2 <= s:
#             return len(nums) - s
        
#         else:
#             return s+1+(len(nums)-b)
        temp1 = min(max(b+1, s+1), max(len(nums)-b, len(nums)-s))
        temp2 = s+1+len(nums)-b
        return min(temp1, temp2)