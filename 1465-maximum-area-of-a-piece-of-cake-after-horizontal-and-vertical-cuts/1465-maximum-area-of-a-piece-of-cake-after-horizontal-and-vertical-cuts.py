class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        horizontalCuts.sort()
        verticalCuts.sort()
        horizontalCuts.append(h)
        verticalCuts.append(w)
        print(horizontalCuts)
        print(verticalCuts)
        h_gap = horizontalCuts[0]
        w_gap = verticalCuts[0]
        for i in range(1, len(horizontalCuts)):
            h_gap = max(h_gap, horizontalCuts[i] - horizontalCuts[i-1])
        
        for j in range(1, len(verticalCuts)):
            w_gap = max(w_gap, verticalCuts[j] - verticalCuts[j-1])
            
        return (h_gap * w_gap)%1000000007