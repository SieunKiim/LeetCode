from collections import defaultdict
class Solution:
    def minDeletions(self, S: str) -> int:
        Dict = defaultdict(int)
        for s in S:
            Dict[s] += 1
        
        value = list(Dict.values())
        value.sort(reverse=True)
        if len(value) == 1:
            return 0

        count = 0
        for i in range(1, len(value)):
            if value[i] >= value[i-1]:
                if value[i-1] <= 1:
                    count += value[i]
                    value[i] = 0
                    continue
                count += (value[i]-value[i-1] + 1)
                value[i] = value[i-1] -1
        # print(value)
        # print(count)
        return count