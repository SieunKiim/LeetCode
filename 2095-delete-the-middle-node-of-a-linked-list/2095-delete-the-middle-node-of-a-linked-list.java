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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null){
            head = null;
        } else{
            ListNode last = head;
            int count = 0;
            while(last != null){
                last = last.next;
                count += 1;
            }
            ListNode delete = head;
            int index = 1;
            while(index < count/2){
                delete = delete.next;
                index += 1;
            }
            ListNode next = delete.next;
            // head.val = next.val;
            delete.next = next.next;
        }
        return head;
    }
}