class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        n = len(s)
        count = 0
        if n == 1:
            return s
        def check(left, right, length):
            if 0 <= left and right <= n-1:
                if s[left] == s[right]:
                    return check(left-1, right+1, length+2)
                    
                else:
                    return length-2
            else:
                return length-2
            
        index = 0
        length = 0
        for i in range(n-1):
            temp = check(i,i,1)
            if s[i] == s[i+1]:
                temp2 = check(i,i+1,2)
                temp = max(temp, temp2)
            if temp > length:
                index = i
                length = temp
            if length % 2 != 0:
                result = s[index - (length // 2): index + (length // 2) + 1]
            else:
                result = s[index - (length // 2) + 1: index + (length // 2) + 1]            
        return result