# result = 0
class Solution:
    
    def trap(self, height: List[int]) -> int:
        start = 0
        end = len(height)-1
        result = 0
        leftTarget = 0
        rightTarget = 0
        while start< end:
            if height[start] <= height[end]:
                if leftTarget < height[start]:
                    leftTarget = height[start]
                else:
                    result +=(leftTarget - height[start])
                start += 1
            else:
                if rightTarget < height[end]:
                    rightTarget = height[end]
                else:
                    result += (rightTarget - height[end])
                end -= 1
                
        return result