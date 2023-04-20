/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public class Position{
        TreeNode node;
        int position;
        
        Position(TreeNode node, int position){
            this.node = node;
            this.position = position;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Position> que = new ArrayDeque<>();
        que.add(new Position(root, 0));
        int res = 0;
        while(!que.isEmpty()){
            int n = que.size();
            int start = -1;
            int end = -1;
            for(int i = 0 ; i<n; i++){
                Position p = que.poll();
                if(i == 0) start = p.position;
                if(i == n-1) end = p.position;
                TreeNode head = p.node;
                if(head.left != null) que.add(new Position(head.left, p.position * 2));
                if(head.right != null) que.add(new Position(head.right, p.position * 2 + 1));
            }
            res = Math.max(res, end-start + 1);
        }
        return res;
    }

}