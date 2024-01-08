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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    public int dfs(TreeNode node, int low, int high){
        if(node == null) return 0;
        
        int l = dfs(node.left, low, high);
        int r = dfs(node.right, low, high);

        int output = 0;
        if(node.val >= low && node.val <= high){
            output += node.val;
        }

        return output + l + r;
    }
}