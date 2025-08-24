class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = 0;

        int output = nums[0];
        int zCount = 1-nums[0];
        int oCount = nums[0];

        while(start <= end && end < n-1 && start < n){
            if(zCount <= 1){
                end += 1;
                if(nums[end] == 1){
                    oCount += 1;
                } else {
                    zCount += 1;
                }
            } else {
                start += 1;
                if(nums[start-1] == 1){
                    oCount -=1;
                } else {
                    zCount -=1;
                }
            }
            output = Math.max(output, oCount);
        }
        if(zCount == 0){
            output-=1;
        }
        return output;
    }

}