class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] check = new boolean[n+1];
        check[0] = true;
        for(int i = 0;i<n;i++){
            if(i > 1 && nums[i] == nums[i-1] && nums[i-2] == nums[i-1]){
                check[i+1] |= check[i-2];
            }
            if(i > 1 && nums[i] == nums[i-1] + 1 && nums[i-2] + 1 == nums[i-1]){
                check[i+1] |= check[i-2];
            }
            if(i>0 && nums[i] == nums[i-1]){
                check[i+1] |= check[i-1];
            }
        }
        return check[n];
    }
}