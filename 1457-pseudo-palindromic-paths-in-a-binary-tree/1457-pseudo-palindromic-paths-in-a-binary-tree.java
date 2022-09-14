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
    int count;
    public int pseudoPalindromicPaths (TreeNode root) {
        count = 0;
        findPath(root, new HashMap<Integer, Integer>());
        return count;
    }
    
    public void findPath(TreeNode root, HashMap<Integer, Integer> path){
        if (root.right == null && root.left == null){
            path.put(root.val, (path.getOrDefault(root.val,0)+1));
            // System.out.println(path);
            int temp = 0;
            for(int val: path.values()){
                if(val %2 != 0) temp += 1;
                if (temp > 1){
                    return ;
                }
            }
            count += 1;
            return ;
        }
        HashMap<Integer, Integer> rightPath = new HashMap<>(path);
        rightPath.put(root.val, (rightPath.getOrDefault(root.val, 0) + 1));
        HashMap<Integer, Integer> leftPath = new HashMap<>(path);
        leftPath.put(root.val, (leftPath.getOrDefault(root.val, 0) + 1));
        if(root.right != null) findPath(root.right,rightPath);
        if (root.left != null) findPath(root.left, leftPath);
        
        
    }
}