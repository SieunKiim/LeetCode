class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int count = 0;
        dp[0] = 0;
        for(int i = 0; i < n ;i++){
            int limit = nums[i];
            for(int j = 1; j<= limit; j++){
                if(i + j >=n) break;
                dp[i+j] = Math.min(dp[i+j], dp[i] + 1);
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}