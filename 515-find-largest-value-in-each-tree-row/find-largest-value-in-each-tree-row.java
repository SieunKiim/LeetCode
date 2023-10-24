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
    List<Integer> output;
    public List<Integer> largestValues(TreeNode root) {
        output = new ArrayList<>();
        dfs(root, 0);
        return output;
    }

    public void dfs(TreeNode node, int depth){
        if(node == null) return;
        if(output.size()<=depth ){
            output.add(node.val);
        } else {
            int temp = Math.max(output.get(depth), node.val);
            output.set(depth, temp);
        }
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }
}