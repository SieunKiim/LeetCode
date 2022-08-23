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
    
    public ListNode head;
    
    public boolean isPalindrome(ListNode root) {
        head = root;
        if (find(root)){
            return true;
        }else {
            return false;
        }
        
    }
    public boolean find(ListNode now){
        if (now != null){
            if (now.next != null){
                if(find(now.next)){
                    System.out.println(now.val + " " +head.val);
                    if(now.val == head.val){
                        head = head.next;
                        return true;
                    }else {
                        return false;
                    }
                } else {
                    return false;
                }
                
            } else {
                System.out.println(now.val + " " +head.val);
                if(now.val == head.val){
                    head = head.next;
                    return true;
                }else {
                    return false;
                }
            }
            
        }
        return true;
    }
}