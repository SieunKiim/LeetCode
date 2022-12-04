class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        
        // long right = Arrays.stream(nums).sum();
        long right = Arrays.stream(nums).mapToLong(i->i).sum();
        // long right = 0;
        // for(int num : nums){
        //     right += num;
        // }
        
        long left = 0;
        int compare = Integer.MAX_VALUE;
        int want = -1;
        
        for(int i = 0; i<n ;i++){
            left += nums[i];
            right -= nums[i];
            
            long leftEv = left/(i+1);
            long rightEv = right;
            if(i != n-1){
                rightEv = rightEv/(n-1-i);
            }
            int temp = (int) Math.abs(leftEv - rightEv);
            if (compare > temp){
                compare = temp;
                want = i;
            }
        }
        return want;
    }
}
