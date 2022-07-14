# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        result = self.tree(preorder, inorder)
        
        return result
        
        
    def tree(self, preorder, inorder):
        if len(preorder) < 1:
            return None
        elif len(preorder) == 1:
            return TreeNode(preorder[0])
        else:
            root = TreeNode(preorder[0])
            splitInde = inorder.index(preorder[0])
            root.left = self.tree(preorder[1:splitInde+1], inorder[:splitInde])

            if splitInde + 1 != len(inorder):
                root.right = self.tree(preorder[splitInde + 1:], inorder[splitInde + 1:])
            else:
                root.right = None

        return root