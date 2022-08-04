class Solution:
    def GCD(self,x,y):
        while y:
            x,y = y, x%y
        return x

    def LCM(self,x,y):
        result = (x*y)//self.GCD(x,y)
        return result

    def mirrorReflection(self, p: int, q: int) -> int:
        temp = self.LCM(p,q)
        x = temp//q
        y = temp//p
        
        if x%2 != 0:
            if y %2 == 0:
                return 0
            else:
                return 1
        else:
            if y %2 == 0:
                return 1
            else:
                return 2
            
        print(x,y)
    
