class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] output = new int[2*n];
        for(int i = 0; i<n ; i++){
            output[2*i] = nums[i];
            output[2*i+1] = nums[i+n];
        }
        return output;
    }
}