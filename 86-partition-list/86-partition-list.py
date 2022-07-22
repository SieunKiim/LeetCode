# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        sub_start =sub = ListNode(-300)
        big_start =big = ListNode(-300)
        while head:
            if head.val < x:
                sub.next = ListNode(head.val)
                sub = sub.next
                    
            
            else:
                big.next = ListNode(head.val)
                big = big.next
                
            head = head.next
        
        sub.next = big_start.next
        return(sub_start.next)
#         while head.next:
            
            
#             head = head.next