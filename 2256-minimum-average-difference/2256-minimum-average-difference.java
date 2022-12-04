class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int minAvgDiff = Integer.MAX_VALUE;
        long currPrefixSum = 0;
        long totalSum = 0;
        for (int index = 0; index < n; ++index) {
            totalSum += nums[index];
        }
        for (int index = 0; index < n; ++index) {
            currPrefixSum += nums[index];
            long leftPartAverage = currPrefixSum;
            leftPartAverage /= (index + 1);
            long rightPartAverage = totalSum - currPrefixSum;
            if (index != n - 1) {
                rightPartAverage /= (n - index - 1);
            }
            int currDifference = (int) Math.abs(leftPartAverage - rightPartAverage);
            if (currDifference < minAvgDiff) {
                minAvgDiff = currDifference;
                ans = index;
            }
        }
        return ans;
    }
//     public int minimumAverageDifference(int[] nums) {
//         int n = nums.length;
//         int right = Arrays.stream(nums).sum();
//         int left = 0;
//         int compare = Integer.MAX_VALUE;
//         int want = -1;
        
//         for(int i = 0; i<n ;i++){
//             left += nums[i];
//             right -= nums[i];
            
//             int leftEv = left/(i+1);
//             int rightEv = right;
//             if(i != n-1){
//                 rightEv /= (n-1-i);
//             }
//             int temp = Math.abs(leftEv - rightEv);
//             if (compare > temp){
//                 compare = temp;
//                 want = i;
//             }
//         }
//         return want;
//     }
}
