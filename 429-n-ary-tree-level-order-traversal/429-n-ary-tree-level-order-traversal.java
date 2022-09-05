/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        find(1, root);
        return result;
    }
    
    public void find(int level, Node x){
        if(x == null) return;
        
        List<Integer> temp;
        if(result.size() < level){
            temp = new ArrayList<>();
            temp.add(x.val);
            result.add(temp);
        } else{
            temp = result.get(level-1);
            temp.add(x.val);
            result.set(level-1, temp);
        }
        
                
        if(x.children.size() != 0){
            for(Node c : x.children){
                find(level+1, c);
            }
        }
    }
}