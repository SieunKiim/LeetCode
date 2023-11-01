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
    HashMap<Integer, Integer> map;
    int big = 0;

    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        dfs(root);
        ArrayList<Integer> output = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == big){
                output.add(entry.getKey());
            }
        }
        int[] result = new int[output.size()];
        for(int i =0; i<output.size(); i++){
            result[i] = output.get(i);
        }
        return result;
    }

    public void dfs(TreeNode head){
        if(head == null)return;
        int temp = map.getOrDefault(head.val, 0);
        map.put(head.val, temp+1);
        big = Math.max(big, temp+1);
        dfs(head.left);
        dfs(head.right);
    }
}