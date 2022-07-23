class Solution:
    def smallestTrimmedNumbers(self, nums: List[str], queries: List[List[int]]) -> List[int]:
        newQ = sorted(queries, key=lambda x: x[1])
        last = 0
        temp = [0] * len(nums)
        dick = {}
        for K_num, slicePoint in newQ:

            if slicePoint != last:  # 재활용
                for n in range(len(nums)):
                    temp[n] = int(nums[n][len(nums[0]) - slicePoint:])

            # print(temp)
            indexTemp = [[i] for i in range(len(nums))]
            for p in range(len(nums)):
                indexTemp[p].append(temp[p])
            indexTemp.sort(key=lambda x:x[1])
            # print(indexTemp)
            want = indexTemp[K_num-1][0]
            dick[(K_num, slicePoint)] = want

        result = []
        for want1, want2 in queries:
            result.append(dick[(want1, want2)])
        return(result)