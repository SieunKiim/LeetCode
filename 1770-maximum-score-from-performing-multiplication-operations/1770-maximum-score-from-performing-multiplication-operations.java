class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        int n = nums.length;
        int[][] dp = new int[m+1][m+1];
        for (int i = 0; i < m+1; i++) {
            Arrays.fill(dp[i], -10000000);
        }

        for (int start = 0; start<m+1 ; start ++){
            for(int end = m; end>=0; end--){
                int index = m-end+start-1;
                if(index >= m) break;
                if(start == 0 && end == m){
                    dp[start][end] = 0;
                    continue;
                }
                if(start == 0){
                    dp[start][end] = dp[start][end+1] + multipliers[index]*nums[n-m+end];
                    continue;
                }
                if(end == m){
                    dp[start][end] = dp[start-1][end] + multipliers[index]*nums[start-1];
                    continue;
                }
                dp[start][end] =Math.max(dp[start][end+1] + multipliers[index]*nums[n-m+end], dp[start-1][end] + multipliers[index]*nums[start-1]);
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i <= m; i++) {
            result = Math.max(result, dp[i][i]);
        }
        // DP 출력부분
         // for(int i = 0; i<m+1 ; i++){
         //     System.out.println(Arrays.toString(dp[i]));
         // }
        return result;
    }
}
