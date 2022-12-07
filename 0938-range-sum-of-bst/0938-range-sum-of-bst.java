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
    public int rangeSumBST(TreeNode root, int low, int high) {
        TreeNode head = root;
        if(root == null) return 0;
        
        int output = 0;
        if(low <= root.val && root.val <= high) output += root.val;
        
        
        if(root.left  != null){
            output += rangeSumBST(root.left, low, high);
        }
        
        if(root.right != null){
            output += rangeSumBST(root.right, low, high);
        }
        
        return output;
        
    }
}