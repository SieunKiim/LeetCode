class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        result = 0
        boxTypes.sort(key=lambda x: x[1])
        print(boxTypes)
        while truckSize:
            if len(boxTypes) == 0:
                break
            num, size = boxTypes.pop(-1)
            if truckSize >= num:
                result += size * num
                truckSize -= num
            else:
                result += truckSize * size
                truckSize = 0
        return result