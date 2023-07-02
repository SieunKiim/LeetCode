class Solution {

    int maxRequest = 0;

    int[][] requests;

    int reqSize;

    public int maximumRequests(int n, int[][] a) {
        reqSize = a.length;
        int[] dp = new int[n];
        requests = a;
        dfs(0, dp, 0);
        return maxRequest;
    }

    private void dfs(int index, int[] dp, int used){
        if(index >= reqSize){
            if(check(dp)) {
                maxRequest = Math.max(maxRequest, used);
            }
            return;
        }

        dfs(index + 1, dp, used);

        dp[requests[index][0]] -= 1;
        dp[requests[index][1]] += 1;

        dfs(index + 1, dp, used + 1);

        dp[requests[index][0]] += 1;
        dp[requests[index][1]] -= 1;

    }

    private boolean check(int[] arr){
        for(int a : arr){
            if(a!= 0) return false;
        }
        return true;
    }
}
