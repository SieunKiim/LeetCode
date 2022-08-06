import math
class Solution:
    def poorPigs(self, buckets: int, minutesToDie: int, minutesToTest: int) -> int:
        i = 0
        N = minutesToTest // minutesToDie +1
        if N == 1:
            return math.ceil(math.log2(buckets))
        while N**i < buckets:
            i+=1
        
        return(i)