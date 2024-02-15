class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long total = 0;
        int n = nums.length;
        for(int num : nums){
            total += num;
        }

        for(int i = n-1 ; i>= 0; i--){
            total = total - nums[i];
            if(nums[i] < total){
                return total + nums[i];
            }
        }
        return -1;
    }
}