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

    int output;

    public int minDepth(TreeNode root) {
        if(root ==null) return 0;
        output = Integer.MAX_VALUE;
        dfs(root, 0);
        return output+1;
    }

    public void dfs(TreeNode head, int depth){
        if(head == null) return;
        dfs(head.left, depth + 1);
        dfs(head.right, depth + 1);
        if(head.left == null && head.right == null){
            output = Math.min(output, depth);
        }
    }
}