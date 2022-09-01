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
    int count= 1;
    public int goodNodes(TreeNode root) {
        if(root.left != null){
            check(root.left, root.val);
        }
        if(root.right != null){
            check(root.right, root.val);
        }
        return count;
    }
    
    public void check(TreeNode X, int last){
        if (X.val >= last){
            count += 1;
            last = X.val;
        }
        if(X.left != null){
            check(X.left, last);
        }
        if(X.right != null){
            check(X.right, last);
        }
    }
}