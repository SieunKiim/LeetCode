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
    private int idx;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        if (inorder.length == 0) return null;
        idx = postorder.length-1;
        TreeNode root = build(inorder, postorder, 0, idx);
        return root;
    }
    
    private TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start>end) return null;
        TreeNode node = new TreeNode(postorder[idx--]);
        if (start==end) return node;
        
        int index = findIdx(inorder, node.val, end);
        node.right = build(inorder, postorder, index+1, end);
        node.left = build(inorder, postorder, start, index-1);
        return node;
    }
    
    private int findIdx(int[] inorder, int val, int end) {
        for (int i=end; i>=0; i--) {
            if (inorder[i]==val) return i;
        }
        return 0;
    }
//     TreeNode root;
//     int[] Inorder;
//     int[] Postorder;
//     public TreeNode buildTree(int[] inorder, int[] postorder) {
//         root = new TreeNode();
//         Inorder = inorder;
//         Postorder = postorder;
//         return dfs(0,postorder.length-1, 0, inorder.length-1);
//     }
    
//     public TreeNode dfs(int postL, int postR, int inL, int inR){
        
//         System.out.println("postL : "+postL+" postR : "+postR + " inL : "+inL + " inR : "+inR);
//         if(inL == inR)return new TreeNode(Postorder[postR]);
//         if(inL>inR)return null;
//         int headNum = Postorder[postR];
//         int index = -1;
//         for(int i = inL;i<=inR; i++){
//             if(Inorder[i] == headNum){
//                 index = i;
//                 break;
//             }
//         }
//         int lSize = index-inL;
//         int rSize = inR-inL-lSize;
//         TreeNode leftTree = dfs(postL, postL+lSize,inL, index-1);
//         TreeNode rightTree = dfs(postR-rSize, postR-1, index+1, inR);
        
//         return new TreeNode(headNum, leftTree, rightTree);
//     }
}