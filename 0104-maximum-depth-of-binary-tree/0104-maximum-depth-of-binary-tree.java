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
    int result;
    public int maxDepth(TreeNode root) {
        result = 0;
        dfs(root, 0);
        return result;
    }
    
    public void dfs(TreeNode node, int depth){
        if(node == null) {
            result = Math.max(result, depth);
            return;
        }
        
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
        
    }
}