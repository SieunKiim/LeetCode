class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = []
        A =[]
        Max = 0
        def findIndex(num):
            start = 0
            end = len(dp)-1
            
            while start != end:
                mid = (start+end)//2
                if num <= dp[mid]:
                    end = mid
                else:
                    start = mid+1
            return start
    
        for n in nums:
            if len(dp) == 0 or dp[-1] < n:
                dp.append(n)
                A.append(len(dp))
                Max = max(Max,len(dp))
            else:
                temp = findIndex(n)
                dp[temp] = n
                # print(dp)
                A.append(temp+1)
                Max = max(Max, temp+1)
        print(A)
        return(Max)