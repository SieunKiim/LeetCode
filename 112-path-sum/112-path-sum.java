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
    int target;
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        return search(root, 0);
    }
    
    public boolean search(TreeNode head, int sum){
        if(head == null){
            return false;
        }
        
        
        if(head.left == null && head.right == null){
            System.out.println(sum+head.val);
            if(sum + head.val == target) return true;
            return false;
        }
        
        boolean result = false;
        
        if(head.left != null) result |= search(head.left, sum + head.val);
        if(head.right != null) result |= search(head.right, sum + head.val);
        return result;
    }
}