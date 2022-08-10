# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        '''''' #SECOND
        if len(nums) == 0:
            return
        mid = len(nums)//2
        Node = TreeNode(nums[mid])
        Node.left = self.sortedArrayToBST(nums[:mid])
        Node.right = self.sortedArrayToBST(nums[mid+1:])
        return Node
        ''''''
        
        ''' #FIRST
        start = 0
        end = len(nums)-1
        if start == end:
            return TreeNode(nums[end])
        mid = (start+end)//2
        if len(nums)%2 == 0:
            mid += 1
        Node = TreeNode(nums[mid])
        Node.left = self.sortedArrayToBST(nums[:mid])
        if mid+1 < len(nums):
            Node.right = self.sortedArrayToBST(nums[mid+1:])
        return Node'''