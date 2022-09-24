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
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        target = targetSum;
        
        findPath(root, new ArrayList<Integer>(), 0);
        List<List<Integer>> output = new ArrayList<>();
        return result;
    }
    
    public void findPath(TreeNode root, ArrayList<Integer> path, int SUM){
        if(root == null){
            return;
        }
        
        ArrayList<Integer> temp = (ArrayList<Integer>)path.clone();
        temp.add(root.val);
        // System.out.println(root.val);
        if(root.left == null && root.right == null) {
            if(SUM + root.val == target){
                // System.out.println(path);
                temp.add(root.val);
                result.add(temp);
                temp.remove(temp.size()-1);
            }
            return;
        }
        
        
        if(root.left != null) findPath(root.left, temp, SUM + root.val);
        
        if(root.right != null) findPath(root.right, temp, SUM + root.val);
        temp.remove(temp.size()-1);
    }
}