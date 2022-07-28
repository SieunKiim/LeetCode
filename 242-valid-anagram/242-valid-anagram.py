from collections import defaultdict
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        S = list(s)
        s_dict = defaultdict(int)
        for tempS in S:
            s_dict[tempS] += 1
        T = list(t)
        
        t_dict = defaultdict(int)
        for tempT in T:
            t_dict[tempT] += 1
        
        if s_dict == t_dict:
            return True
        else:
            return False