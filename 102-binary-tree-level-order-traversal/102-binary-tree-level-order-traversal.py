# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        que = deque()
        if root == None:
            return []
        que.append(root)
        result = [[root.val]]
        while que:
            temp = []
            for _ in range(len(que)):
                out = que.popleft()
                if out.left:
                    temp.append(out.left.val)
                    que.append(out.left)
                if out.right:
                    temp.append(out.right.val)
                    que.append(out.right)
            if len(temp):
                result.append(temp)
        return(result)