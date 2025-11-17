class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int distance = 100000;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                if(distance <k) return false;
                distance = 0;
            } else {
                distance ++;
            }
        }
        return true;
    }
}