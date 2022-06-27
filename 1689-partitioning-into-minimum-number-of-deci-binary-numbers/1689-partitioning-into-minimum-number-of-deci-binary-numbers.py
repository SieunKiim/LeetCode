class Solution:
    def minPartitions(self, n: str) -> int:
        Max = 0
        for s in n:
            Max = max(Max, int(s))
            # print(s)
        return Max