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
class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        // ListNode root = new ListNode(0,head);
        ListNode root = head;
        while(head != null){
            head = head.next;
            count += 1;
        }
        // System.out.println(count);
        count = count/2 + 1;
        
        while(count != 1){
            root = root.next;
            count -= 1;
        }
        return root;
    }
}