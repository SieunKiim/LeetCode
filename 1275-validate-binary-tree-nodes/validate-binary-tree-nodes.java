class Solution {
    boolean[] used;
    int[] left;
    int[] right;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        left = leftChild;
        right = rightChild;
        used = new boolean[n];

        int root = getRoot(n, leftChild, rightChild);
        if (root == -1) {
            return false;
        }

        return dfs(root) && checkUsed();
    }

    public boolean dfs(int index){
        if(used[index]) return false;

        used[index] = true;
        boolean result = true;
        if(left[index] != -1) {
            result &= dfs(left[index]);
            }
        
        if(right[index] != -1) { 
            result &=dfs(right[index]);
            }
        return result;
    }

    public boolean checkUsed(){
        boolean result = true;
        for(boolean t : used){
            result &= t;
        }
        return result;
    }

    public int getRoot(int n, int[] left, int[] right) {
        Set<Integer> children = new HashSet<>();
        for (int node : left) {
            children.add(node);
        }
        
        for (int node : right) {
            children.add(node);
        }
        
        for (int i = 0; i < n; i++) {
            if (!children.contains(i)) {
                return i;
            }
        }
        
        return -1;
    }
}