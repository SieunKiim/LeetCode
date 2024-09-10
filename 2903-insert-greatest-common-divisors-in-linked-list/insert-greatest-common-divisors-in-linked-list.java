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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode output = head;
        while(head.next != null){
            injection(head);
            head = head.next.next;
        }
        return output;
    }

    public void injection(ListNode head){
         if(head.next == null) return;
        int insertVal = gdc(head.val, head.next.val);
        ListNode temp = head.next;
        ListNode newNext = new ListNode(insertVal, temp);
        head.next = newNext;
    }

    public int gdc(int a, int b){
        while(b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}