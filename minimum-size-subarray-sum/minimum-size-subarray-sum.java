class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int output = Integer.MAX_VALUE;
        while(left < n){
            while(right < n && sum <target){
                sum += nums[right];
                right += 1;
            }
            if(sum >= target) output = Math.min(output, right-left);
            sum -= nums[left];
            left += 1;
        }
        if(output == Integer.MAX_VALUE) output = 0;
        return output;
    }
}