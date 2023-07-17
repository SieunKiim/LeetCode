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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> a = fun1(l1, new Stack<>());
        Stack<Integer> b = fun1(l2, new Stack<>());
        // System.out.println(a);
        return fun2(a,b);
    }

    public Stack<Integer> fun1(ListNode head, Stack<Integer> stack){
        Stack<Integer> output = new Stack<>();
        while(head != null){
            output.push(head.val);
            head = head.next;
        }
        return output;
    }

    public ListNode fun2(Stack<Integer> a, Stack<Integer> b){
        int sum = 0;
        int carry = 0;

        ListNode output = new ListNode();
        while(!a.isEmpty() || !b.isEmpty()){
            if(!a.isEmpty()) sum += a.pop();
            if(!b.isEmpty()) sum += b.pop();
            carry = sum/10;
            output.val = sum%10;
            ListNode temp = new ListNode(carry);
            temp.next = output;
            output = temp;
            sum = carry;
        }

        if(carry == 0){
            return output.next;
        }
        return output;
    }
}