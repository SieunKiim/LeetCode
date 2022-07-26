# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def dfs(root, target, history):
            history.append(root)
            if root.val == target.val:
                return (True, history)            
            
            if root.left:
                check1, history1 = dfs(root.left, target, history)
                if check1:
                    return (True, history1)
            if root.right:
                check2, history2 = dfs(root.right, target, history)
                if check2:
                    return (True, history2)
            history.pop()
            return (False, history)
        
        BOOLP, tempP = dfs(root, p, [])
        BOOLQ, tempQ = dfs(root, q, [])
        
        for i in range(len(tempP)):
            print(tempP[i].val,end=" ")
        print("")  
        for i in range(len(tempQ)):
            print(tempQ[i].val,end=" ")
        print("")
        for i in range(min(len(tempP),len(tempQ))):
            if tempP[i].val != tempQ[i].val:
                return tempP[i-1]
        return tempP[i]