class Solution {
    public int minimizeArrayValue(int[] nums) {
        // 그리디 풀이 O(n)
        int n = nums.length;
        long sum = 0;
        int output = 0;
        for(int i = 0; i< n ; i++){
            sum += nums[i];
            int mean = (int) Math.ceil((double)sum/(i+1));
            if(mean <= nums[i]) output = Math.max(output, mean);
        }
        return output;
        
        
        
        // 이분탐색 풀이
//         int n = nums.length;
//         int left = Integer.MAX_VALUE;
//         int right = Integer.MIN_VALUE;
//         for(int num : nums){
//             left = Math.min(left, num);
//             right = Math.max(right, num);
//         }
        
        
//         while(left < right){
//             int mid = (left+right) / 2;
            
            
//         }
        
//         return left;
    }
}