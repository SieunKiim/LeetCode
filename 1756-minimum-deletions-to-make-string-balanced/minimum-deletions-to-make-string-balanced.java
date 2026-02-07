class Solution {
    public int minimumDeletions(String s) {
        // 앞에있는 b를 빼거나, 뒤에있는 a를 빼거나
        int n = s.length();
        int[][] preSum = new int[n+1][2];
        for(int i =1 ;i<=n;i++){
            preSum[i][0] = preSum[i-1][0];
            preSum[i][1] = preSum[i-1][1];
            preSum[i][s.charAt(i-1)-'a'] += 1;
        }
        // for(int[] arr : preSum){
        //     System.out.println(Arrays.toString(arr));
        // }
        
        int output = Integer.MAX_VALUE;
        for(int i =1;i<=n;i++){
            int countA = preSum[n][0] - preSum[i][0];
            int countB = preSum[i-1][1];
            output = Math.min(output, countA+countB);
        }
        return output;
    }
}