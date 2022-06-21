class Solution(object):
    def furthestBuilding(self, heights, bricks, ladders):
        """
        :type heights: List[int]
        :type bricks: int
        :type ladders: int
        :rtype: int
        """
        if len(heights) == 1:
            return 0
        maxDiff = 0
        heap = []
        arr = []
        total = 0
        LADD = []
        for i in range(0,len(heights)-1):
            diff = heights[i+1] - heights[i]
            if diff > 0:
                heapq.heappush(heap,diff)
                if len(heap) > ladders:
                    temp = heapq.heappop(heap)
                    total+= temp

                if total > bricks:
                    return i
        return len(heights)-1