class Solution:
    def targetIndices(self, nums: List[int], target: int) -> List[int]:
        nums.sort()
        result = []
        for n in range(len(nums)):
            if nums[n] == target:
                result.append(n)
        return result