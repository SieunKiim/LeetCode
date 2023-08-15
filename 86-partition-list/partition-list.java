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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode();
        ListNode big = new ListNode();
        ListNode smallpoint = small;
        ListNode bigpoint = big;
        while(head != null){
            if (head.val < x){
                smallpoint.next = head;
                smallpoint = smallpoint.next;
            } else {
                bigpoint.next = head;
                bigpoint = bigpoint.next;
            }
            head = head.next;
        }
        bigpoint.next = null;
        smallpoint.next = big.next;
        return small.next;
    }
}