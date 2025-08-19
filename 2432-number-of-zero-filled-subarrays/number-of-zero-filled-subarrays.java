class Solution {
    public long zeroFilledSubarray(int[] nums) {
        // List<Integer> arr = new ArrayList<>();
        int count = 0;
        long res = 0;
        for(int num : nums){
            if(num == 0){
                count += 1;
                res += count;
            } else {
                count = 0;
            }
        }
        return res;
    }
}