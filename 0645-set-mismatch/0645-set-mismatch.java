class Solution {
    public int[] findErrorNums(int[] nums) {
        // 반복된거, 없는거
        int[] result = new int[2];
        int[] used = new int[nums.length+1];
        
        for(int n : nums){
            if(used[n] == 1){
                result[0] = n;
            } else {
                used[n] = 1;
            }
        }
        for(int i = 1;i<nums.length+1; i++){
            if(used[i] == 0)
                result[1] = i;
        }
        return result;
    }
}