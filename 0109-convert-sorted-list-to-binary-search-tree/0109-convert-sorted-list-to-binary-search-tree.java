/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode headPointer = head;
        while(head != null){
            head = head.next;
            n += 1;
        }
        TreeNode output = listToTree(headPointer, n);
        return output;
    }
    
    public TreeNode listToTree(ListNode head, int n){
        if(head == null || n == 0) {
            return null;
        }      
        int mid = n/2;
        int count = 0;
        TreeNode output = new TreeNode();
        if(mid != 0){
            output.left = listToTree(head,mid);
        }
        while(head != null && count < mid){
            count += 1;
            head = head.next;
        }
        output.val = head.val;
        if(n-mid-1 != 0){
            output.right = listToTree(head.next, n-mid-1);
        }
        return output;
    }
}