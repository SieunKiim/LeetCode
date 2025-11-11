class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[n+1][m+1][len+1];

        for(int k = 1; k<len+1;k++){
            int countOne = 0;
            int countZero = 0;
            for(char c : strs[k-1].toCharArray()){
                if(c == '0') countZero += 1;
                else countOne += 1;
            }
                        // System.out.println("one  : " + countOne + " zero : " + countZero);


            for(int i = 0;i<=n;i++){
                for(int j = 0; j<=m;j++){
                    if(i-countOne >= 0 && j-countZero >= 0)
                        {dp[i][j][k] = Math.max(dp[i][j][k-1], dp[i-countOne][j-countZero][k-1]+ 1);}
                        else{
                            dp[i][j][k] = dp[i][j][k-1];
                        }
                }
            }

            // for(int i = 0;i<=n;i++){
            //     for(int j = 0; j<=m;j++){
            //         System.out.print(dp[i][j][k]);
            //     }
            //     System.out.println("");
            // }        
        }

        return dp[n][m][len];
    }
}