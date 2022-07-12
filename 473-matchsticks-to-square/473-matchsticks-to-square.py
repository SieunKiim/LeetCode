class Solution:
    
        
    def makesquare(self, matchsticks: List[int]) -> bool:
        result = False
        length = sum(matchsticks)//4
        # print("한 변의 길이",length)
        if max(matchsticks) > length:
            return False
        count = 4
        while max(matchsticks) == length:
            matchsticks.remove(length)
            count -= 1
            if len(matchsticks) == 0:
                return True
        
        if sum(matchsticks) == length*count:
            matchsticks.sort()
            used = [0] * len(matchsticks)
            return self.dfs(0, matchsticks, used, count, length, 0)
        else:
            return False
        
    def dfs(self,temp , matchs, used, count, length, index):
        if count == 0:
            return True
        res = False
        for i in range(index, len(matchs)):
            if used[i] == 0:
                if temp + matchs[i] < length:
                    used[i] = 1
                    if self.dfs(temp + matchs[i], matchs, used, count, length, i+1):
                        return True

                elif temp + matchs[i] == length:
                    used[i] = 1
                    if self.dfs(0, matchs, used, count-1, length, 0):
                        return True
                
                used[i] = 0
        return res