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
    public int maxLevelSum(TreeNode root) {
        int output = Integer.MIN_VALUE;
        Deque<TreeNode> que = new ArrayDeque<>();
        int lev = 1;
        int outLev = 1;
        que.add(root);
        while(!que.isEmpty()){
            int n = que.size();
            int temp = 0;
            for(int i =0 ;i<n;i++){
                TreeNode polled = que.poll();
                temp += polled.val;
                if(polled.left != null) que.add(polled.left);
                if(polled.right != null) que.add(polled.right);
            }
            if(output < temp){
                output = temp;
                outLev = lev;
            }
            lev += 1;
        }
        return outLev;
    }
}