import heapq
class Solution:
    def isPossible(self, target: List[int]) -> bool:
        if len(target) == 1:
            if target[0] == 1:
                return True
            else:
                return False
        
        arr = []
        for i in target:
            heapq.heappush(arr,-i)

        while arr:
            temp = heapq.heappop(arr)
            if temp == -1:
                continue
            Sum = sum(arr)
            
            if temp-Sum >= 0:
                return False
            put = (temp%Sum)
            if put == 0:
                heapq.heappush(arr, Sum)
            else:
                heapq.heappush(arr, put)
            # print(sum(arr))
        return True