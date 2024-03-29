class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        wiggle = []
        if len(nums) == 1:
            return 1

        for i in range(1, len(nums)):
            if nums[i] - nums[i - 1] != 0:
                wiggle.append(nums[i] - nums[i - 1])
        
        if len(wiggle) == 0:
            return 1
        count = 2
        for w in range(1, len(wiggle)):
            if wiggle[w] * wiggle[w - 1] < 0:
                count += 1

        return count