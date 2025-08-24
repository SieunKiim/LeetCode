class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0, zCount = 0, output = 0;
        
        for (int end = 0; end < nums.length; end++) {
            if(nums[end] == 0){
                zCount++;
            }

            while(zCount > 1 && start<end){
                if(nums[start]== 0){
                    zCount--;
                }
                start++;
            }
            output = Math.max(output, end-start);
        }
        
        return output;
    }
}