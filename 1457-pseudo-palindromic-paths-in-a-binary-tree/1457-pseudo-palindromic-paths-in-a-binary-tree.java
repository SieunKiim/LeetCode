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
    int[] arr;
    public int pseudoPalindromicPaths (TreeNode root) {
        count = 0;
        arr = new int[10];
        findPath(root);
        return count;
    }
    
    public void findPath(TreeNode root){
        if(arr[root.val] == 1){
            arr[root.val] = 0;
        } else{
            arr[root.val] = 1;
        }
        if (root.right == null && root.left == null){
            // System.out.println(Arrays.toString(arr));
            int temp = 0;
            for(int n : arr){
                if (n == 1) temp += 1;
                if (temp > 1) break;
            }
            if(temp <= 1) count += 1;
            if(arr[root.val] == 1){
                arr[root.val] = 0;
            } else{
                arr[root.val] = 1;
            }
            return ;
        }
        if (root.right != null) findPath (root.right);
        if (root.left != null) findPath(root.left);
        
        if(arr[root.val] == 1){
            arr[root.val] = 0;
        } else{
            arr[root.val] = 1;
        }
    }
}