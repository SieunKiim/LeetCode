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
    TreeMap<Integer, ListNode> index;
    ListNode output;
    public ListNode mergeKLists(ListNode[] lists) {
        index = new TreeMap<>();
        output = null;
        for(int i = 0; i< lists.length; i++){
            ListNode head = lists[i];
            while(head != null){
                putListNode(new ListNode(head.val));
                head = head.next;
            }
        }
        return output;
    }
    
    public void putListNode(ListNode node){
        Map.Entry<Integer, ListNode> temp2 = index.floorEntry(node.val);
        if (temp2 == null) {
            node.next = output;
            output = node;
            index.put(node.val, output);
            return;
        }
        ListNode temp = temp2.getValue();
        ListNode nextnext = temp.next;
        temp.next = node;
        node.next = nextnext;
        index.put(node.val, node);
    }
}