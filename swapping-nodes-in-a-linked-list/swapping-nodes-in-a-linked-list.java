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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode origin = head;
        ListNode output = origin;
        int n= 1;
        while(head.next != null){
            head = head.next;
            n += 1;
        }
        if(n == 1) return origin;
        ListNode a = null;
        ListNode b= null;
        int i = 1;
        System.out.println(n);
        while(origin != null){
            System.out.println(origin.val);
            if(i == k) a = origin;
            if(i == n-k+1) b= origin;
            origin = origin.next;
            i++;
        }
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
        return output;
    }
}