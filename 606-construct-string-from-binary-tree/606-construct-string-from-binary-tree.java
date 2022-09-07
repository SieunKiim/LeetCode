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

    public String tree2str(TreeNode root) {
        if(root == null) return "";
        String answer = "";
        answer += root.val;
        
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        if((left + right).length() == 0){
            return answer;
        } else {
            if(right.length() == 0){
                return answer+ "(" + left + ")";
            }
            return answer + "(" + left + ")" + "(" + right +")";
        }
        
    }
}