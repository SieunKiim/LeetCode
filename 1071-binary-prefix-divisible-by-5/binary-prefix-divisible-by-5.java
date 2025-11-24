class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int temp  =0;
        List<Boolean> output = new ArrayList<>();
        for(int num:nums){
            temp  = temp*2 + num;
            if(temp % 5 == 0){
                output.add(true);
            }else {
                output.add(false);
            }
            temp = temp%5;
        }
        return output;
    }
}