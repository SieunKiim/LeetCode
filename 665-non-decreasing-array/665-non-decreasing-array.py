class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        if len(nums) <= 2:
            return True
        temp = [0] * len(nums)
        for n in range(1,len(nums)):
            if nums[n] < nums[n-1]:
                temp[n] = 1
        print(temp)

        if sum(temp) > 1:
            return False
        elif sum(temp) == 0:
            return True
        else:
            index = temp.index(1)
            print(index)
            if 0 < index < len(nums)-1 and index != 1:
                if nums[index-1] <= nums[index+1]:
                    return True
                if nums[index-2] > nums[index]:
                    return False
            return True

        