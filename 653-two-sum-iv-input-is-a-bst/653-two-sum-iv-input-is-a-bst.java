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
    HashSet<Integer> group = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(group.contains(k-root.val)) return true;
        group.add(root.val);
        boolean result = false;
        if(root.left != null) result |= findTarget(root.left, k);
        if(root.right != null) result |= findTarget(root.right, k);
        return result;
    }
}