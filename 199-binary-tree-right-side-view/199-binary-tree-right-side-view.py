# import sys
# sys.setrecursionlimit(10**7)
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        def dfs(tree, deep):
            if len(result) == deep:
                result.append(tree.val)
            
            if tree.right:
                dfs(tree.right, deep+1)
            if tree.left:
                dfs(tree.left, deep+1)
        
        if root:
            dfs(root, 0)
        return result
                
#         deque 로 풀었음 ---------------------
#         result = []
#         if root == None:
#             return []
#         else:
#             result.append(root.val)
#         que = deque()
#         que.append(root)
#         while True:
#             temp = []
#             length = len(que)
#             for i in range(length):
#                 q = que.popleft()
                
#                 if q.left:
#                     que.append(q.left)
#                     temp.append(q.left.val)
#                 if q.right:
#                     que.append(q.right)
#                     temp.append(q.right.val)
            
#             if len(temp):
#                 result.append(temp[-1])
#             else:
#                 break
#         return (result)