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
    int res = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return res;
    }
    
    public void dfs(TreeNode head, boolean side, int len){
        if(head == null) return;
        
        if(side){
            dfs(head.left, false, len + 1);
            dfs(head.right, true, 1);
        }
        else {
            dfs(head.right, true, len + 1);
            dfs(head.left, false, 1);
        }
        // System.out.println(len);
        res = Math.max(res, len);
        
    }
}