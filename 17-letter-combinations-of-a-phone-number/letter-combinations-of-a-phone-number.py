import itertools

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        arr = [0,0,['a','b','c'],['d','e','f'],['g','h','i'],['j','k','l'],['m','n','o'],['p','q','r','s'],['t','u','v'],['w','x','y','z']]
        result = []
        if len(digits) != 0:
            k = int(digits[0])
            result = arr[k]
        
        for i in range(1, len(digits)):
            index = int(digits[i])
            result = list(itertools.product(result, arr[index]))
            for k in range(len(result)):
                result[k] = ''.join(result[k])
        
        print(result)
        
        return result
        