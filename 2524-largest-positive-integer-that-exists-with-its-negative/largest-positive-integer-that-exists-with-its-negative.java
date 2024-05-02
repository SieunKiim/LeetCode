class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            if(nums[left] == -nums[right]){
                return nums[right];
            }
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                right--;
            } else{
                left++;
            }
        }
        return -1;
    }
}