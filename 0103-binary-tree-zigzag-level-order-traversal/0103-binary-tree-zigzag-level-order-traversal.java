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
    List<List<Integer>> output;
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        output = new ArrayList<>();
        dfs(root, 1);
        return output;
    }
    
    public void dfs(TreeNode head, int depth){
        if(head == null) return;
        
        if(output.size() < depth){
            output.add(new ArrayList<>());
        }
        
        List<Integer> temp = output.get(depth-1);
        if(depth %2 != 0) temp.add(head.val);
        else temp.add(0, head.val);
        dfs(head.left, depth+1);
        dfs(head.right, depth+1);
    }
}