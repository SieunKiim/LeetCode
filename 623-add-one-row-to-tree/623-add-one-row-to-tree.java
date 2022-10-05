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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null) return null;
        if(depth == 1) {
            TreeNode newNode = new TreeNode(val, root, null);
            return newNode;
        }
        find(root, val, depth-2);
        return root;
    }
    public void find(TreeNode head, int val, int depth){
        if(depth == 0){
            TreeNode newNodeLeft = new TreeNode(val, head.left, null);
            TreeNode newNodeRight = new TreeNode(val, null, head.right);
            head.left = newNodeLeft;
            head.right = newNodeRight;
            return;
        }
        if(head.left != null) find(head.left, val, depth-1);
        if(head.right != null) find(head.right, val, depth-1);
    }
}