class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long constantZero = 0;
        long output = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] == 0) constantZero += 1;
            else{
                output += subArrays(constantZero);
                constantZero = 0;
            }
        }
        return output+=subArrays(constantZero);
    }
    
    public long subArrays(long n){
        return n*(n+1)/2;
    }
}
