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
    public TreeNode pruneTree(TreeNode root) {
        if (containsOne(root)){
            return root;
        } else {
            return null;
        }
    }
    
    public boolean containsOne(TreeNode root){
        if (root == null)
            return false;
        
        
        if (!containsOne(root.left)){
            root.left = null;
        } 
        if (!containsOne(root.right)){
            root.right = null;
        } 
        
        return (root.val == 1 || containsOne(root.right) || containsOne(root.left));
    }
}