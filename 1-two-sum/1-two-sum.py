class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        total = {}
        lengthh = len(nums)
        
        for n in range(lengthh):
            total[nums[n]] = n
        
        for n in range(lengthh):
            want = target- nums[n]
            if want in total and n != total[want]:
                return [n, total[want]]
        
            
        