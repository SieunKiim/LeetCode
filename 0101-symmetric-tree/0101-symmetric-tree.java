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
    ArrayList<Integer> left;
    ArrayList<Integer> right;
    public boolean isSymmetric(TreeNode root) {
        left = new ArrayList<>();
        right = new ArrayList<>();
        
        // if(root.right.val != root.left.val) return false;
        checkLeft(root.left);
        checkRight(root.right);
        // System.out.println("left : "+ left);
        // System.out.println("right : "+ right);
        return left.equals(right);
        
    }
    
    public void checkLeft(TreeNode head){
        if(head == null) {
            left.add(null);
            return;
        }
        left.add(head.val);
        checkLeft(head.left);
        checkLeft(head.right);
    }
    
    public void checkRight(TreeNode head){
        if(head == null) {
            right.add(null);
            return;
        }        
        right.add(head.val);
        checkRight(head.right);
        checkRight(head.left);
    }
}