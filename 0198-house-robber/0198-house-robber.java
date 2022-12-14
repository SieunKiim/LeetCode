class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n+1];
        dp[1] = nums[0];
        dp[2] = nums[1];
        for(int i = 3; i <=n ;i++){
            dp[i] = nums[i-1] + Math.max(dp[i-3], dp[i-2]);
        }
        // System.out.println(Arrays.toString(dp));
        return Math.max(dp[n],dp[n-1]);
    }
}