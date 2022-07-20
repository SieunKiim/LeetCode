class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        def issubseq(t):
            current_pos = -1
            stack = []
            for i in t:
                if indices[i]:
                    pos = bisect.bisect_right(indices[i], current_pos)
                    if pos == len(indices[i]):
                        return False
                    current_pos = indices[i][pos]
                else:
                    return False
            return True
        
        
        
        indices = defaultdict(list)
        for i, c in enumerate(s):
            indices[c].append(i)
        
                
        hashmap = {}
        
        count = 0
        for word in words:
            if word not in hashmap:
                if issubseq(word):
                    count += 1
                    hashmap[word] = True
                else:
                    hashmap[word] = False
            else:
                if hashmap[word]:
                    count += 1
        return count