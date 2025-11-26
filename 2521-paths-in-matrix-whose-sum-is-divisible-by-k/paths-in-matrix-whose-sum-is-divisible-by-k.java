class Solution {
    private int mod = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] map = new int[n+1][m+1][k];
        map[1][1][grid[0][0]%k] = 1;
        // System.out.println(map[1][1][0]);
        for(int i =1 ;i<=n;i++){
            for(int j = 1;j<=m;j++){
                int gridVal = grid[i-1][j-1];
                for(int t = 0; t<k;t++){
                    int index = (t + gridVal)%k;
                    map[i][j][index] = (map[i][j][index] + map[i-1][j][t]) % mod;
                    map[i][j][index] = (map[i][j][index] + map[i][j-1][t]) % mod;
                }
            }
        }
        return map[n][m][0];
    }
}