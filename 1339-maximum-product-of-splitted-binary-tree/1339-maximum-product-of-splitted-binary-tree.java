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
    
    long total = 0;
    int mod = (int)(Math.pow(10, 9) + 7);
    long result = 0;
    
    public int maxProduct(TreeNode root) {
        total = getSum(root);
        getSum(root);
        return (int) (result% (1e9+7));
    }
    
    public int getSum(TreeNode head){
        if(head == null) return 0;
        int output = head.val;
        if(head.left != null){
            output += getSum(head.left);
        }
        if(head.right != null){
            output += getSum(head.right);
        }
        result = Math.max(result, output * (total-output));
        return output;
    }
}