class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int output = Integer.MIN_VALUE;
        int n = energy.length;
        int[] dp = new int[n + 1];
        for(int i = 1;i < n+1 ;i++){
            dp[i] = Math.max(dp[Math.max(0,i-k)] + energy[i-1], energy[i-1]);
        }
        System.out.println(Arrays.toString(dp));
        for(int i = n; i>n-k;i--){
            output = Math.max(output,dp[i]);
        }
        return output;
    }

}