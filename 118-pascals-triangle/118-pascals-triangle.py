class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        result = [[1]]
        for i in range(1,numRows):
            temp = [1]
            target = result[-1]
            for p in range(1, len(target)):
                temp.append(target[p] + target[p-1])
            temp.append(1)
            result.append(temp)
        return result