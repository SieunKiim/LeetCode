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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode copied = head;
        while(copied!= null){
            size+=1 ;
            copied = copied.next;
        }
        // int[] sizeChecker= new int[k];
        ListNode[] output = new ListNode[k];
        for(int i = 0; i<k;i++){
            int targetSize = size / k;
            if(i + 1 <= size%k){
                targetSize += 1;
            }
            if(targetSize == 0){
                continue;
            }
            ListNode temp = new ListNode(head.val);
            head = head.next;
            ListNode flag = temp;
            int count = 1;
            while(head != null && count < targetSize){
                temp.next = new ListNode(head.val);
                head = head.next;
                temp = temp.next;
                count += 1;
            }
            output[i] = flag;
        }
        return output;
    }
}