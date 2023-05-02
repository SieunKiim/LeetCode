class Solution {
    public int arraySign(int[] nums) {
        int temp  = 1;
        for(int num : nums){
            if(num == 0) return 0;

            if(num >0){
                temp *= 1;
            } else{
                temp *= -1;
            }
        }
        if(temp > 0) return 1;
        return -1;

    }
}