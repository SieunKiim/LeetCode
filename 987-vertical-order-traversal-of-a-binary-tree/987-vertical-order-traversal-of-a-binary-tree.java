public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Point implements Comparable<Point>{
    TreeNode x;
    int i;
    int j;
    Point(TreeNode x, int i, int j){
        this.x = x;
        this.i = i;
        this.j = j;
    }
    
    @Override
    public int compareTo(Point p){
        if(this.j == p.j){
            if(this.i == p.i){
                return this.x.val - p.x.val;
            }
            return this.i-p.i;
        }
        return this.j-p.j;
    }
}

class Solution {
    PriorityQueue<Point> heap = new PriorityQueue<>();
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        putIn(root, 0,0);
        List<List<Integer>> result = new ArrayList<>();
        int index = Integer.MAX_VALUE;
        List<Integer> temp = new ArrayList<>();
        while(!heap.isEmpty()){
            Point p = heap.poll();
            if(p.j != index){
                if(index != Integer.MAX_VALUE){
                    // Collections.sort(temp);
                    result.add(temp);
                    temp = new ArrayList<>();
                }
                temp.add(p.x.val);
                index = p.j;
            } else {
                temp.add(p.x.val);
            }
        }
        if(temp.size() != 0){
            // Collections.sort(temp);
            result.add(temp);
        }
        return result;   
    }
    
    public void putIn(TreeNode x,int i,int j){
        if(x == null){
            return;
        }
        heap.add(new Point(x,i,j));
        putIn(x.left, i+1, j-1);
        putIn(x.right, i+1, j+1);
    }
}