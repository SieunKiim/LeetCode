# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        def gogo(root):
            
            if not root:
                return 
            if root.left:
                home = root.left
                while home.right:
                    home = home.right
                home.right = root.right
                root.right = root.left
                root.left = None
            gogo(root.right)
            
                    
        gogo(root)
        