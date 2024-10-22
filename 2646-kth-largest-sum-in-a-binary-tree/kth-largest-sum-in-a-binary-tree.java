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
    HashMap<Integer, Long> sumArr;
    public long kthLargestLevelSum(TreeNode root, int k) {
        sumArr = new HashMap<>();
        dfs(root, 0);
        Long[] valuesArray = sumArr.values().toArray(new Long[0]);
        Arrays.sort(valuesArray, Collections.reverseOrder());
        System.out.println(Arrays.toString(valuesArray));
        if(k-1 >= valuesArray.length) return -1;
        return valuesArray[k-1];
    }

    public void dfs(TreeNode head, int depth){
        Long temp = sumArr.getOrDefault(depth, 0L);
        sumArr.put(depth, temp + head.val);
        if(head.left != null){
            dfs(head.left, depth+1);
        }
        if(head.right != null){
            dfs(head.right, depth + 1);
        }
    }
}