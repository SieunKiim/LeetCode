# class MyCalendar:
    
#     def __init__(self):
#         tree = [0] * (10**9) * 4
#         return tree

#     def book(self, start: int, end: int) -> bool:
#         def checkSum(start, end, node, left,right):
#             if left > end or right<start:
#                 return 0
#             if left <= start and end<=right:
#                 return tree[node]
#             mid = (start+end) //2
#             return checkSum(start,mid,node*2,left,right) + checkSum(mid+1, end, node*2 + 1, left, right)

#         def update(start,end, node, left, right):
            
#         if checkSum(0, (10**9) * 4 -1, 1, start,end-1): #합이 1 이상이면
#             return False

#     def __init__(self):
#         self.tree = 0
        
#     def book(self, start:int, end:int) -> bool:
#         temp = 2**(end) - 2**(start)
#         if temp & self.tree == 0:
#             self.tree += temp
#             return True
#         return False

class MyCalendar(object):
    def __init__(self):
        self.booking = []

    def book(self, start, end):
        for i, j in self.booking:
            if i < end and start < j:
                return False
        self.booking.append((start, end))
        return True
        
        

# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)