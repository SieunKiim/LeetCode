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
    
    int result = 0;
    
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        getMax(root);
        return result;
    }
    
    private int getMax(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int output = root.val;
        // int left = 0;
        // int right = 0;
        // if(root.left != null){
        int left = Math.max(0, getMax(root.left));
        // }
        
        // if(root.right != null){
        int right = Math.max(0, getMax(root.right));
        // }
        
        result = Math.max(result, left+right+output);
        // System.out.println(output);
        return Math.max(left+output, right+output);
    }
}