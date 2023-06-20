class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n];
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i = 0; i< n; i++){
            if(i != 0){
                prefix[i] = prefix[i-1] + (long)nums[i];
            }
            output[i] = -1;
        }
        if(k >= n) return output;
        for(int i = k; i< n;i ++){
            if(i-k >= 0 && i+k < n){
                output[i] = (int)(((long)nums[i-k] + prefix[i+k] - prefix[i-k])/(long)(2*k + 1));
            }
        }
        return output;
    }
}