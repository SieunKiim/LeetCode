/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> result = new ArrayList<Double>();
        int level = 0;
        list(root, level);
        
        System.out.println(map);
        for (ArrayList<Integer> arr : map){
            int len = arr.size();
            double sum = 0;
            for(int a : arr){
                sum+=a;
            }
            result.add(Math.round(sum*100000.0/len)/100000.0);
        }
        return result;
    }
    public void list(TreeNode X, int level){
        if (X == null) return;
        if(map.size() == level){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(X.val);
            map.add(temp);
        } else {
            ArrayList<Integer> temp = map.get(level);
            temp.add(X.val);
            map.set(level,temp);
        }
        list(X.left, level+1);
        list(X.right, level+1);
    }
}