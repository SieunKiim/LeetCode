class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] dp = new int[n];
        int total= 0;
        int index = 0;
        int sum = 0;
        for(int i = 0; i<n;i++){
            dp[i] = gas[i]-cost[i];
            total += dp[i];
            sum += dp[i];
            if(sum < 0){
                sum = 0;
                index = i+1;
            }
        }
        if(total < 0) return -1;
        
        return index;
    }
}