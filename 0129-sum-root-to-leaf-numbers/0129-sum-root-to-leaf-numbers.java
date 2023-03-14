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
    public int sumNumbers(TreeNode root) {
        output = 0;
        dfs(root, 0);
        return output;
    }
    
    public void dfs(TreeNode head, int sum){
        if(head == null) return;
        if(head != null && head.left == null && head.right == null){
            output += sum*10 + head.val;
            return;
        }
        sum = sum * 10 + head.val;
        dfs(head.left, sum);
        dfs(head.right, sum);
    }
}