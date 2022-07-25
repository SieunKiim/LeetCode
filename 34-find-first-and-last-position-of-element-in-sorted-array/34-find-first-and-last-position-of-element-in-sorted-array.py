class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start = -1
        end = -1
        for n in range(len(nums)):
            if start == -1 and nums[n] == target:
                start = n
            
            if start != -1 and nums[n] == target:
                end = n
        
        return [start, end]