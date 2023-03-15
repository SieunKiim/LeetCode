class Solution {
    public boolean isCompleteTree(TreeNode root) {
        boolean emptyFlag = false;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode now = que.poll();
            if(now == null) emptyFlag = true;
            else{
                if (emptyFlag) return false;
                que.add(now.left);
                que.add(now.right);
            }
            
        }
        return true;
    }
}