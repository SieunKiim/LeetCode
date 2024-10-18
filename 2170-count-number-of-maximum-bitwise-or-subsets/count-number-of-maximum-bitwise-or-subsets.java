class Solution {
    private int output;
    private long maxVal;

    public int countMaxOrSubsets(int[] nums) {
        long k = 0;
        output = 0;
        for(int n : nums){
            k |= n;
        }
        maxVal = k;
        for (int i = 0; i < nums.length; i++) {
            dfs(i, nums, nums[i]);
        }
        return output;
    }

    private void dfs(int index, int[] nums, long val){

        if(val == maxVal){
            output += (int) (Math.pow(2, nums.length-1 -index));
            return;
        }
        for (int i = index+1; i < nums.length; i++) {
            dfs(i, nums, val | nums[i]);
        }
    }
}