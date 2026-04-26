class Solution {
    List<List<Integer>> output = new ArrayList<>();
    int target = -1;
    public List<List<Integer>> combinationSum(int[] candidates, int t) {
        target = t;
        dfs(candidates,0, new ArrayList<>(), 0);
        return output;
    }

    private void dfs(int[] candidates, int nowSum, List<Integer> buffer, int index){
        if(nowSum > target) return;
        if(nowSum == target){
            output.add(new ArrayList<>(buffer));
            return;
        }
        for(int i = index; i<candidates.length;i++){
            buffer.add(candidates[i]);
            dfs(candidates, nowSum + candidates[i], buffer, i);
            buffer.remove(buffer.size()-1);
        }
    }
}