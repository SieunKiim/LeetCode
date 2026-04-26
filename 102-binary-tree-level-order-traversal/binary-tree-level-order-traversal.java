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
    private class Node{
        TreeNode tree;
        int level;
        public Node(TreeNode val, int level){
            this.tree = val;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        ArrayDeque<Node> que = new ArrayDeque<>();

        que.add(new Node(root, 0));
        while(!que.isEmpty()){

            Node nowNode = que.poll();
            if(nowNode.tree == null) continue;
            if(output.isEmpty() || output.size() <nowNode.level+1){
                output.add(new ArrayList<>());
            }
            output.get(nowNode.level).add(nowNode.tree.val);
            que.add(new Node(nowNode.tree.left, nowNode.level+1));
            que.add(new Node(nowNode.tree.right, nowNode.level+1));
        }

        return output;
    }
}