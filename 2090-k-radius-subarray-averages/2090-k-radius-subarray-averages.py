class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        dp = [0,nums[0]]
        result = [0] * len(nums)
        if len(nums) == 1:
            if k == 0:
                return nums
            else:
                return [-1]
        for n in range(1,len(nums)):
            dp.append(dp[-1]+nums[n])
        for i in range(len(nums)):
            if i-k < 0 or i+k > n:
                result[i] = -1
            else:
                temp = (dp[k+i+1] - dp[i-k])//(2*k+1)
                result[i] = temp
                
                
        return result