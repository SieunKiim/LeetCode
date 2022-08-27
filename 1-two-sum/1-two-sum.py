class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        total = {}
        for n in range(len(nums)):
            total[nums[n]] = n
        
        for n in range(len(nums)):
            want = target- nums[n]
            if want in total and n != total[want]:
                return [n, total[want]]
        
            
        