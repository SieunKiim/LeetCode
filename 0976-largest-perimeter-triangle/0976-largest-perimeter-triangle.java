class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int total = nums[n-2]+nums[n-3];
        for(int i = n-1; i>= 2; i--){
            if(nums[i] < total) return total + nums[i];
            else{
                if(i == 2){continue;}
                total += (nums[i-3] - nums[i-1]);
            }
        }
        return 0;
    }
}