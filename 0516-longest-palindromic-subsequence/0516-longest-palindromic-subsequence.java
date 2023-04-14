class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = n-1; i>= 0; i--){
            dp[i][i] = 1;
            for(int j = i+1; j<n;j++){
                dp[i][j] = 1;
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
                    
            }
        }
        return dp[0][n-1];
    }
    
    public boolean checkPalin(ArrayList<Character> s){
        int n = s.size();
        for(int i = 0; i<n/2;i++){
            if(s.get(i)!= s.get(n-1-i)) return false;
        }
        return true;
    }
}