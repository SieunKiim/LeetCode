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
    PriorityQueue<Integer> pq;
    public int minDiffInBST(TreeNode root) {
        pq = new PriorityQueue<>();
        dfs(root);
        int gap = Integer.MAX_VALUE;
        int temp = pq.poll();
        while(!pq.isEmpty()){
            int pop = pq.poll();
            gap = Math.min(gap, pop-temp);
            temp = pop;
        }
        return gap;
    }
    
    public void dfs(TreeNode head){
        if(head == null) return;
        pq.add(head.val);
        dfs(head.left);
        dfs(head.right);
    }
    
}