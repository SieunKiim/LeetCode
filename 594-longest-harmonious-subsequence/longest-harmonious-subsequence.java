class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);

        int output = 0;

        int left = 0;
        int right = 0;
        while(left < nums.length && right < nums.length){
            if(nums[Math.min(right,nums.length-1)]-nums[Math.min(nums.length-1,left)] == 1){
                output = Math.max(output, right-left + 1);
            }
            if(nums[right]-nums[left] <= 1){
                right += 1;
            } else {
                left += 1;
            }
        }
        return output;
    }
}