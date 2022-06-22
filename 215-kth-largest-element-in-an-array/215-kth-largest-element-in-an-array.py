import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for n in nums:
            heapq.heappush(heap, -n)
        # print(heap)
        for _ in range(k-1):
            heapq.heappop(heap)
        temp = heapq.heappop(heap)
        return -temp