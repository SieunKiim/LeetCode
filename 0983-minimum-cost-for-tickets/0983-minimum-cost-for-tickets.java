class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] hudle = {0,6,29};
        int n = days.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i<=n;i++){
            int last = dp[i-1];
            for(int j= 0; j<3; j++){
                int coverDay = days[i-1] + hudle[j];
                int index = i-1;
                while(index < n && coverDay >= days[index]){
                    dp[index+1] = Math.min(dp[index+1], last + costs[j]);
                    index += 1;
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}